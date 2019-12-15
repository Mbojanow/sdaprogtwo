package pl.sdacademy.prog.paczka;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.WillNotClose;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.prog.stra.GenericException;

@Slf4j
public class PickEventsStreamProcessor implements StreamProcessor {

  private static final Long DATA_WAIT_TIME_IN_MILLIS = 10L;
  private static final int SINGLE_READ_CHUNK_SIZE_IN_BYTES = 1;
  private static final byte EVENT_SEPARATOR = '\n';

  private final int maxEventsNum;
  private final Duration maxProcessingTime;
  private final PickEventMapper mapper;
  private final PickEventAggregationService pickEventAggregationService;
  private final PickerStatisticsOutputWriter pickerStatisticsOutputWriter;

  public PickEventsStreamProcessor(final int maxEventsNum, final Duration maxProcessingTime, final PickEventMapper mapper,
                                   final PickEventAggregationService pickEventAggregationService,
                                   final PickerStatisticsOutputWriter pickerStatisticsOutputWriter) {
    this.maxEventsNum = maxEventsNum;
    this.maxProcessingTime = maxProcessingTime;
    this.mapper = mapper;
    this.pickEventAggregationService = pickEventAggregationService;
    this.pickerStatisticsOutputWriter = pickerStatisticsOutputWriter;
  }

  @Override
  public void process(@WillNotClose final InputStream source, @WillNotClose final OutputStream sink) throws IOException {
    final LocalDateTime startingTime = LocalDateTime.now();
    int readEventsNum = 0;
    final List<Byte> event = new ArrayList<>();
    final List<PickEvent> pickEvents = new ArrayList<>();
    while (shouldContinueProcessing(readEventsNum, startingTime)) {
      if (source.available() == 0) {
        waitForAvailableData();
      } else {
        final byte readByte = source.readNBytes(SINGLE_READ_CHUNK_SIZE_IN_BYTES)[0];
        if (readByte == EVENT_SEPARATOR && event.isEmpty()) {
          log.info("Read alive signal was sent");
        } else if (readByte == EVENT_SEPARATOR) {
          mapper.toPickEvent(event).ifPresent(pickEvents::add);
          readEventsNum++;
          event.clear();
        } else {
          event.add(readByte);
        }
      }
    }
    final List<PickerStatistics> statitics = pickEventAggregationService.aggregate(pickEvents);
    pickerStatisticsOutputWriter.writeStatistics(statitics, sink);
  }

  private boolean shouldContinueProcessing(final int readEventsNum, final LocalDateTime startingTime) {
    return readEventsNum < maxEventsNum && startingTime.plus(maxProcessingTime)
        .isAfter(LocalDateTime.now());
  }

  private void waitForAvailableData() {
    try {
      Thread.sleep(DATA_WAIT_TIME_IN_MILLIS);
    } catch (final InterruptedException exp) {
      throw new GenericException("Interrupted during waiting for new data", exp);
    }

  }
}
