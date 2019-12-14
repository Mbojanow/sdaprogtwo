package pl.sdacademy.prog.backpacks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.prog.stra.GenericException;

@Slf4j
public class TestExecutionInfoLoader {

  private static final int EXPECTED_LINE_ELEMENTS_NUM = 2;
  private static final int TEST_NAME_INDEX = 0;
  private static final int TEST_EXECUTION_TIME_INDEX = 1;
  private static final String DATA_SEPARATOR = ":";

  public List<TestExecutionInfo> load(final String filePath) {
    try (final BufferedReader bufferedReader
             = new BufferedReader(new FileReader(filePath))) {
      return bufferedReader.lines()
          .map(this::toTestExecutionInfo)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .collect(Collectors.toList());
    } catch (final IOException exp) {
      throw new GenericException("Cannot read input file " + filePath, exp);
    }
  }

  private Optional<TestExecutionInfo> toTestExecutionInfo(final String line) {
    final String[] splitLine = line.split(DATA_SEPARATOR);
    if (splitLine.length != EXPECTED_LINE_ELEMENTS_NUM
        || !splitLine[TEST_EXECUTION_TIME_INDEX].matches("[0-9]+")) {
      log.warn("Line has incorrect format");
      return Optional.empty();
    }
    final String testName = splitLine[TEST_NAME_INDEX];
    final Long executionTime = Long.valueOf(splitLine[TEST_EXECUTION_TIME_INDEX]);
    return Optional.of(new TestExecutionInfo(testName, executionTime));
  }
}
