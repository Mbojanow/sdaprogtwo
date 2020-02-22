package pl.sdacademy.prog.strategy;

public class TextModificationStrategySelector {

  public TextModificationStrategy getTextModificationStrategy(final String strategyType) {
    switch (strategyType) {
      case "COMPRESS":
        return new CompressionModificationStrategy();
      case "CAMEL_CASE":
        return new CamelCaseModificationStrategy();
      case "KEBAB_CASE":
        return new KebabCaseModificationStrategy();
    }
    return new NoOpModificationStrategy();
  }
}
