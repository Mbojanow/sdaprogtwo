package pl.sdacademy.prog.day6.strategy;

import java.util.stream.Stream;

public class TextCompressionModificationStrategy implements TextModificationStrategy {
  @Override
  public void process(final String text) {
    final StringBuilder output = new StringBuilder(text.length());
    boolean nextWordShouldStartWithUpperCase = false;
    for (final Character chr : text.trim().toCharArray()) {
      if (Character.isAlphabetic(chr)) {
// rownowazne linijce nizej
//        Character chToAdd;
//        if (nextWordShouldStartWithUpperCase) {
//          chToAdd = Character.toUpperCase(chr);
//        } else {
//          chToAdd = chr;
//        }
        final Character charToAdd = nextWordShouldStartWithUpperCase ? Character.toUpperCase(chr) : chr;
        output.append(charToAdd);
        nextWordShouldStartWithUpperCase = false;
      } else {
        nextWordShouldStartWithUpperCase = true;
      }
    }

    System.out.println(output.toString());
  }
}
