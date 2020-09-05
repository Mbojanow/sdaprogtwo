package pl.sdacademy.prog.strategy;

public class TextModificationStrategyProvider {

  public TextModificationService selectStrategy(final String type) {
    final TextModificationType textModificationType;
    try {
      textModificationType = TextModificationType.valueOf(type);
    } catch (final IllegalArgumentException exp) {
      return NoOpTextModificationStrategy.getInstance();
    }

    switch (textModificationType) {
      case CAMEL_CASE:
        return CamelCaseModificationService.getInstance();
      case COMPRESSION:
        return TextCompressionModificationService.INSTANCE;
      case KEBAB_CASE:
        return KebabCaseModificationStrategy.getInstance();
    }
    throw new StrategyException("Unknown strategy type");
  }
}
