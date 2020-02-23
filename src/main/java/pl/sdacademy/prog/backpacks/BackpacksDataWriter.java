package pl.sdacademy.prog.backpacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.prog.streams.SdaException;

public class BackpacksDataWriter {

  public void writeBackpacksData(final List<BackpackTests> backpacks,
                                 final String targetDirectory) {
    backpacks.forEach(backpack -> saveBackpackData(backpack, targetDirectory,
        backpacks.indexOf(backpack)));
  }

  private void saveBackpackData(final BackpackTests backpack, final String basePath,
                                final int backpackIndex) {
    final Path path = Paths.get(basePath + "/backpack" + backpackIndex + ".txt");
    try {
      Files.write(path, getBackpackData(backpack), StandardOpenOption.CREATE);
    } catch (IOException e) {
      throw new SdaException("Cannot write to file", e);
    }
  }

  private List<String> getBackpackData(final BackpackTests backpack) {
    return backpack.getTestInfos().stream()
        .map(testExecutionInfo ->
            testExecutionInfo.getName() + ":" + testExecutionInfo.getExecutionTime())
        .collect(Collectors.toList());
  }
}
