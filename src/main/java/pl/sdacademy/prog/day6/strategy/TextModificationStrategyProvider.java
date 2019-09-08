package pl.sdacademy.prog.day6.strategy;

import java.util.List;

public class TextModificationStrategyProvider {

  public TextModificationStrategy getStrategyByType(final String type) {
    final List<String> allNames = TextModificationType.getAllValueNames();
    if (!allNames.contains(type)) {
      return NoOpModicationStrategy.getInstance();
    }

    final TextModificationType enumType = TextModificationType.valueOf(type);
    switch (enumType) {
      case COMPRESSION:
        return TextCompressionModificationStrategy.getInstance();
      case KEBAB_CASE:
        return KebabCaseModificationStrategy.getInstance();
      case CAMEL_CASE:
        return CamelCaseModificationStrategy.INSTANCE;
    }
    throw new UnsupportedStrategyTypeException("Unsupported strategy type");
  }
}
