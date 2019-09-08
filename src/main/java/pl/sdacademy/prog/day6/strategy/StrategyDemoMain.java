package pl.sdacademy.prog.day6.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyDemoMain {

  public static void main(String[] args) {
    final String type = args[0];
    final String fileWithText = args[1];

    // przed java7
//    BufferedReader bufferedReader = null;
//    try {
//      bufferedReader = new BufferedReader(new FileReader(fileWithText));
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    } finally {
//      if (bufferedReader != null) {
//        try {
//          bufferedReader.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    }

    String toModify;
    try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithText))) {
      toModify = bufferedReader.lines().collect(Collectors.joining("\n"));
    } catch (final IOException exp) {
      throw new SdaException("Cannot open file " + fileWithText, exp);
    }

    final TextModificationStrategyProvider provider = new TextModificationStrategyProvider();

    final TextModificationStrategy strategyByType = provider.getStrategyByType(type);

    log.info("Preparing to modify text:\n" + toModify);
    strategyByType.process(toModify);
  }
}
