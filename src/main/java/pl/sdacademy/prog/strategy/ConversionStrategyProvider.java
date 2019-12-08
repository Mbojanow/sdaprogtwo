package pl.sdacademy.prog.strategy;

public class ConversionStrategyProvider {

  public TextConversionStrategy getStrategy(final ConversionType type) {
    switch (type) {
      case CAMEL_CASE:
        return CamelCaseConversionStrategy.getInstance();
      case KEBAB_CASE:
        return KebabCaseConversionStrategy.getInstance();
      case COMPRESSION:
        return CompressionConversionStrategy.getInstance();
    }
    return NoOpConversionStrategy.INSTANCE;
  }
}
