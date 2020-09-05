package pl.sdacademy.prog.backpacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.prog.currencies.SdaException;

public class BackpacksDataWriter {

  private static final String LINE_TEMPLATE = "%s:%d";
  private static final String OUTPUT_PATH_TEMPLATE = "%s/data_%d.txt";

  public void saveToFiles(final List<Backpack> backpacks, final String outputDir) {
    backpacks.forEach(backpack -> saveToFile(backpack, outputDir));
  }

  private void saveToFile(final Backpack backpack, final String outputDir) {
    final List<String> lines = backpack.getTestExecutionInfos().stream()
        .map(testExecutionInfo -> String.format(LINE_TEMPLATE, testExecutionInfo.getName(), testExecutionInfo.getExecutionTimeInMillis()))
        .collect(Collectors.toList());
    try {
      Files.write(Paths.get(String.format(OUTPUT_PATH_TEMPLATE, outputDir, backpack.getIndex())),
          lines, StandardOpenOption.CREATE);
    } catch (IOException e) {
      throw new SdaException("Cannot write test data", e);
    }
  }
}
