package pl.sdacademy.prog.strategy;

public class TextProcessingFacade {

  private final CustomCommandLineParser customCommandLineParser;
  private final FileContentProvider fileContentProvider;
  private final ConversionStrategyProvider conversionStrategyProvider;

  public TextProcessingFacade(final CustomCommandLineParser customCommandLineParser, final FileContentProvider fileContentProvider,
                              final ConversionStrategyProvider conversionStrategyProvider) {
    this.customCommandLineParser = customCommandLineParser;
    this.fileContentProvider = fileContentProvider;
    this.conversionStrategyProvider = conversionStrategyProvider;
  }

  public void process(final String[] args) {
    customCommandLineParser.parse(args);
    final String content = fileContentProvider
        .readContent(customCommandLineParser.getFilePathArgValue());
    final TextConversionStrategy conversionStrategy
        = conversionStrategyProvider
        .getStrategy(customCommandLineParser.getConversionTypeArgValue());
    System.out.println(conversionStrategy.modify(content));
  }
}
