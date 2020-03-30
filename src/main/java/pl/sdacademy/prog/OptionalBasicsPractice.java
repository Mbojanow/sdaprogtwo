package pl.sdacademy.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalBasicsPractice {

  public Optional<Integer> findFirstCharIndex(final String toCheck, final char lookupChar) {
    for (int idx = 0; idx < toCheck.length(); idx++) {
      if (toCheck.charAt(idx) == lookupChar) {
        return Optional.of(idx);
      }
    }
    return Optional.empty();
  }

  public Optional<Integer> findFirstEvenDigit(final int number) {
    final List<Integer> digits = new ArrayList<>();
    int leftover = number;
    while (leftover > 0) {
      digits.add(leftover % 10);
      leftover = leftover / 10;
    }

    Collections.reverse(digits);
    return digits.stream()
        .filter(elem -> elem % 2 == 0)
        .findFirst();
  }
}
