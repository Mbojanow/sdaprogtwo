package pl.sdacademy.prog.day6.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TextModificationType {
  COMPRESSION,
  CAMEL_CASE,
  KEBAB_CASE;

  public static List<String> getAllValueNames() {
    return Stream.of(TextModificationType.values())
        .map(Enum::name)
        .collect(Collectors.toList());
  }
}
