package pl.sdacademy.prog.strategy;


import static java.util.Objects.isNull;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompressionModificationStrategy implements TextModificationStrategy {

  private static CompressionModificationStrategy instance = null;

  public static CompressionModificationStrategy getInstance() {
    if (isNull(instance)) {
      instance = new CompressionModificationStrategy();
    }
    return instance;
  }

  @Override
  public String modify(final String input) {
    final StringBuilder output = new StringBuilder(input.length());
    boolean shouldNextCharBeUppercased = false;
    for (final char c : input.trim().toCharArray()) {
      if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '\n') {
        char charToAdd = c;
        if (shouldNextCharBeUppercased) {
          charToAdd = Character.toUpperCase(c);
          shouldNextCharBeUppercased = false;
        }
        output.append(charToAdd);
      } else {
        shouldNextCharBeUppercased = true;
      }
    }

    return output.toString();
  }
}
