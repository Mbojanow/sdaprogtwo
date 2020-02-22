package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CamelCaseModificationStrategy implements TextModificationStrategy {

  private static final CamelCaseModificationStrategy instance = new CamelCaseModificationStrategy();

  public static CamelCaseModificationStrategy getInstance() {
    return instance;
  }

  @Override
  public String modify(final String input) {
    final StringBuilder output = new StringBuilder(input.length());
    boolean shouldNextCharBeUppercased = false;
    boolean isFirstChar = true;
    for (final char c: input.trim().toCharArray()) {
      if (!Character.isWhitespace(c)) {
        char charToAdd = c;
        if (isFirstChar) {
          charToAdd = Character.toLowerCase(c);
          isFirstChar = false;
        }

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
