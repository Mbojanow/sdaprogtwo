package pl.sdacademy.prog.strategy;

public class CompressionModificationStrategy implements TextModificationStrategy {

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
