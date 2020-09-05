package pl.sdacademy.prog.strategy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class KebabCaseModificationStrategy implements TextModificationService {

  @Override
  public String modify(final String toModify) {
    //Stream.of(toModify.trim().split(" "))
    return Arrays.stream(toModify.trim().split(" "))
        .map(String::toLowerCase)
        .map(this::removeHyphensFromBeginningAndEnd)
        .filter(str -> !str.isEmpty())
        .collect(Collectors.joining("-"));
  }

  private String removeHyphensFromBeginningAndEnd(final String input) { // "", "-"
    if (input.length() <= 1) {
      return input.equals("-") ? "" : input;
    }
    final int startIndex = input.charAt(0) == '-' ? 1 : 0; // 1
    final int endIndex = input.charAt(input.length() - 1) == '-' ? input.length() - 1 : input.length();
    return input.substring(startIndex, endIndex); // [ )
  }
}
