package pl.sdacademy.prog.strategy;

import java.util.Optional;

import org.apache.commons.cli.ParseException;

import pl.sdacademy.prog.streams.SdaException;

public class TextModificationProcessFacade {
  private final CustomCommandLineParser customCommandLineParser;
  private final FileContentReader fileContentReader;
  private final TextModificationStrategySelector strategySelector;

  public TextModificationProcessFacade(final CustomCommandLineParser customCommandLineParser,
                                       final FileContentReader fileContentReader,
                                       final TextModificationStrategySelector strategySelector) {
    this.customCommandLineParser = customCommandLineParser;
    this.fileContentReader = fileContentReader;
    this.strategySelector = strategySelector;
  }

  public String process(final String[] args) throws ParseException {
    customCommandLineParser.parse(args);
    final Optional<String> typeOptionValue = customCommandLineParser.getTypeOptionValue();
    if (typeOptionValue.isEmpty()) {
      throw new SdaException("Type option is missing");
    }
    final TextModificationStrategy strategy = strategySelector
        .getTextModificationStrategy(typeOptionValue.get());

    final Optional<String> fileOptionValue = customCommandLineParser.getFileOptionValue();
    if (fileOptionValue.isEmpty()) {
      throw new SdaException("File option is missing");
    }
    final String toModify = fileContentReader.readContent(fileOptionValue.get());
    return strategy.modify(toModify);
  }
}
