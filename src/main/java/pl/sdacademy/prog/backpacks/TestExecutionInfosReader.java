package pl.sdacademy.prog.backpacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.prog.streams.SdaException;

public class TestExecutionInfosReader {

  private static final int EXPECTED_DATA_LEN = 2;
  private static final String DATA_SEPARATOR = ":";
  private static final int TEST_NAME_INDEX = 0;
  private static final int TEST_EXECUTION_TIME_INDEX = 1;

  public List<TestExecutionInfo> readFromFile(final String path) {
    try {
      return Files.readAllLines(Paths.get(path)).stream()
          .map(line -> line.split(DATA_SEPARATOR))
          .filter(splitElements -> splitElements.length != EXPECTED_DATA_LEN)
          .map(this::toTestExecutionInfo)
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new SdaException("Cannot read file", e);
    }
  }

  private TestExecutionInfo toTestExecutionInfo(final String[] splitElements) {
    return new TestExecutionInfo(splitElements[TEST_NAME_INDEX],
        Long.parseLong(splitElements[TEST_EXECUTION_TIME_INDEX]));
  }
}
