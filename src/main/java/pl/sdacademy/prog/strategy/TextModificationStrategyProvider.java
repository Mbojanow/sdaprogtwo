package pl.sdacademy.prog.strategy;

public class TextModificationStrategyProvider {

  public TextModificationService selectStrategy(final String type) {
    final TextModificationType textModificationType = TextModificationType.valueOf(type);
    switch (textModificationType) {
      case CAMEL_CASE:
        return new CamelCaseModificationService();
      case COMPRESSION:
        return new TextCompressionModificationService();
      case KEBAB_CASE:
        return new KebabCaseModificationStrategy();
    }
    throw new StrategyException("Unknown strategy type");
  }
}
