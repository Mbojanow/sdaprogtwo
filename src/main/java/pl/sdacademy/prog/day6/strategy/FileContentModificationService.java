package pl.sdacademy.prog.day6.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileContentModificationService {

  private final TextModificationStrategyProvider provider;

  public FileContentModificationService(final TextModificationStrategyProvider provider) {
    this.provider = provider;
  }

  public void processFile(String[] args) {
    final String type = args[0];
    final String fileWithText = args[1];
    final String toModify = readContentAsString(fileWithText);
    final TextModificationStrategy strategyByType = provider.getStrategyByType(type);

    log.info("Preparing to modify text:\n" + toModify);
    strategyByType.process(toModify);
  }

  private String readContentAsString(final String filePath) {
    //tzw. try with resources - zamyka za pomoca close obiekty implementujace interfejs Closable
    // a taki implementuje BufferedReader
    try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      return bufferedReader.lines().collect(Collectors.joining("\n"));
    } catch (final IOException exp) {
      throw new SdaException("Cannot open file " + filePath, exp);
    }
  }
}
