package pl.sdacademy.prog.paczka;

import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class PickerStatisticsOutputWriter {

  private final ObjectMapperFactory objectMapperFactory;

  public PickerStatisticsOutputWriter(final ObjectMapperFactory objectMapperFactory) {
    this.objectMapperFactory = objectMapperFactory;
  }

  @SneakyThrows
  public void writeStatistics(final List<PickerStatistics> statistics, final OutputStream output) {
    final ObjectMapper commonObjectMapper = objectMapperFactory.createCommonObjectMapper();
    output.write(commonObjectMapper.writeValueAsBytes(statistics));
  }

}
