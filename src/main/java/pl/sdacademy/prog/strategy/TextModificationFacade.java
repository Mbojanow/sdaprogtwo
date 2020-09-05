package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.ParseException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // <- tworzy konstruktor dla pól tylko z modyfikatorem final
//@AllArgsConstructor <-
public class TextModificationFacade {

  private final CustomCommandLineParser customCommandLineParser;
  private final FileContentReader fileContentReader;
  private final TextModificationStrategyProvider textModificationStrategyProvider;

  public void process(String[] args) {
    try {
      customCommandLineParser.parse(args);
    } catch (ParseException e) {
      System.out.println("FAILED TO PARSE ARGS " + e.getMessage());
      return;
    }
    final String toModify = fileContentReader.readContent(customCommandLineParser.getFilePath());
    final TextModificationService textModificationService = textModificationStrategyProvider
        .selectStrategy(customCommandLineParser.getModificationType());
    System.out.println(textModificationService.modify(toModify));
  }
}
