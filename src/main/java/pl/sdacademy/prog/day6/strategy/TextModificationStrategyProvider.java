package pl.sdacademy.prog.day6.strategy;

import java.util.List;

public class TextModificationStrategyProvider {

  public TextModificationStrategy getStrategyByType(final String type) {
    final List<String> allNames = TextModificationType.getAllValueNames();
    if (!allNames.contains(type)) {
      return new NoOpModicationStrategy();
    }

    final TextModificationType enumType = TextModificationType.valueOf(type);
    switch (enumType) {
      case COMPRESSION:
        return new TextCompressionModificationStrategy();
      case KEBAB_CASE:
        return new KebabCaseModificationStrategy();
      case CAMEL_CASE:
        return new CamelCaseModificationStrategy();
    }
    throw new UnsupportedStrategyTypeException("Unsupported strategy type");
  }
}
