package pl.sdacademy.prog.strategy;

public class TextModificationStrategySelector {

  public TextModificationStrategy getTextModificationStrategy(final String strategyType) {
    switch (strategyType) {
      case "COMPRESS":
        return CompressionModificationStrategy.getInstance();
      case "CAMEL_CASE":
        return CamelCaseModificationStrategy.getInstance();
      case "KEBAB_CASE":
        return KebabCaseModificationStrategy.INSTANCE;
    }
    return NoOpModificationStrategy.getInstance();
  }
}
