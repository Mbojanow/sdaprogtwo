package pl.sdacademy.prog.backpacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.prog.currencies.SdaException;

public class TestExecutionInfoReader {

  public List<TestExecutionInfo> readFromFile(final String path) {
    try {
      return Files.readAllLines(Paths.get(path)).stream()
          .map(line -> line.split(":")) // ":" nazwać
          .filter(splitLine -> splitLine.length == 2) // dodać informowanie na ekran o niepoprawnej linii
          .map(splitData -> new TestExecutionInfo(splitData[0], Long.parseLong(splitData[1])))// magiczne stałe trzebaby nazwać
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new SdaException("Cannot read test data", e);
    }
  }
}
