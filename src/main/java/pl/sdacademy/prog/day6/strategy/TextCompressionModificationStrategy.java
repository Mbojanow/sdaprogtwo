package pl.sdacademy.prog.day6.strategy;

import static java.util.Objects.isNull;

import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


// double checked
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextCompressionModificationStrategy implements TextModificationStrategy {

  private static TextCompressionModificationStrategy instance;

  public static TextCompressionModificationStrategy getInstance() {
    if (isNull(instance)) {
      synchronized (TextCompressionModificationStrategy.class) {
        if (isNull(instance)) {
          instance = new TextCompressionModificationStrategy();
        }
      }
    }
    return instance;
  }

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
