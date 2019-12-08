package pl.sdacademy.prog.strategy;

public class ConversionStrategyProvider {

  public TextConversionStrategy getStrategy(final ConversionType type) {
    switch (type) {
      case CAMEL_CASE:
        return new CamelCaseConversionStrategy();
      case KEBAB_CASE:
        return new KebabCaseConversionStrategy();
      case COMPRESSION:
        return new CompressionConversionStrategy();
    }
    return new NoOpConversionStrategy();
  }
}
