package pl.sdacademy.prog.day6.strategy;

public class CamelCaseModificationStrategy implements TextModificationStrategy {

  @Override
  public void process(final String text) {
    final StringBuilder output = new StringBuilder(text.length());
    boolean shouldNextAlphabeticCharBeUpperCased = false;

    for (final Character ch : text.trim().toCharArray()) {
      if (ch == ' ') {
        shouldNextAlphabeticCharBeUpperCased = true;
        continue;
      }

      Character charToAdd = ch;
      if (shouldNextAlphabeticCharBeUpperCased && Character.isAlphabetic(ch)) {
        charToAdd = Character.toUpperCase(ch);
        shouldNextAlphabeticCharBeUpperCased = false;
      }

      output.append(charToAdd);
    }

    System.out.println(output.toString());
  }
}
