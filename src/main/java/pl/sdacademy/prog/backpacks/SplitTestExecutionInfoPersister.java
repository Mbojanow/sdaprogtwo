package pl.sdacademy.prog.backpacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import pl.sdacademy.prog.stra.GenericException;

public class SplitTestExecutionInfoPersister {

  private static final String OUTPUT_FILE_NAME_TEMPLATE = "backpack_%d_%s.txt";

  public void saveSplitBackpacks(final List<List<TestExecutionInfo>> splitBackpacks,
                                 final String targetDirectory) {
    //backpack_index_data.txt
    for (int backpackIndex = 0; backpackIndex < splitBackpacks.size(); backpackIndex++) {
      saveBackpackInfo(splitBackpacks.get(backpackIndex), backpackIndex, targetDirectory);
    }
  }

  private void saveBackpackInfo(final List<TestExecutionInfo> testExecutionInfos,
                                final int backpackIndex,
                                final String targetDirectory) {
    final String outputFile = createOutputFilePath(targetDirectory, backpackIndex);
    try (final BufferedWriter bufferedWriter
             = new BufferedWriter(new FileWriter(outputFile))) {
      testExecutionInfos
          .forEach(testExecutionInfo -> saveTestExecutionInfoToFile(testExecutionInfo, bufferedWriter));
    } catch (final IOException exp) {
      throw new GenericException("Cannot save data to file " + outputFile, exp);
    }
  }

  private void saveTestExecutionInfoToFile(final TestExecutionInfo testExecutionInfo,
                                           final BufferedWriter bufferedWriter) {
    final String lineOutput = testExecutionInfo.getTestName()
        + ":" + testExecutionInfo.getExecutionTime();
    try {
      bufferedWriter.write(lineOutput);
      bufferedWriter.newLine();
    } catch (final IOException exp) {
      throw new GenericException("Cannot write data to file", exp);
    }
  }

  private String createOutputFilePath(final String targetDirectory,
                                      final int backpackIndex) {
    final StringBuilder outputPathBuilder = new StringBuilder();
    outputPathBuilder.append(targetDirectory);
    if (!targetDirectory.endsWith("/")) {
      outputPathBuilder.append("/");
    }
    final String filename = String.format(OUTPUT_FILE_NAME_TEMPLATE, backpackIndex,
        LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
    outputPathBuilder.append(filename);
    return outputPathBuilder.toString();
  }
}
