package pl.sdacademy.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalBasicsPractice {

  /*Stwórz klasę OptionalBasicsPractice, a w niej metodę,
   która na podstawie wejściowego Stringa i chara,
    zwraca indeks chara opakowany w Optional.*/

  public Optional<Integer> findCharIndex(final String input, final char c) {
    final int index = input.indexOf(c);
    if (index == -1) {
      return Optional.empty();
    }
    return Optional.of(index);
  }

  /*W klasie OptionalBasicsPractice stwórz metodę,
  która z danej liczby znajdzie pierwszą parzystą cyfrę (licząć „od lewej”),
   tylko jeżeli jest ona różna od zera
   */

  //12345 -> [2]
  //13602 -> [6]
  // 137 -> []

  //12345 -> [1, 2, 3, 4, 5] -> 2
  // 12345 / 10 -> 1234 i 5 reszty -> [5]
  // 1234 / 10 -> 123 i 4 reszty [5, 4]
  // 123 / 10 -> 12 -> 3 reszty [5, 4, 3]

  public Optional<Integer> findFirstEvenDigit(final int number) {
    final List<Integer> digits = new ArrayList<>();

    int remainder = number;
    while(remainder > 0) {
      digits.add(remainder % 10);
      remainder = remainder / 10;
    }

    Collections.reverse(digits);
    return digits.stream()
        .filter((value) -> value % 2 == 0)// lambda implementuje Predicate<Integer>
        .filter((value) -> value != 0) // pozbywamy się zer by Kinga :)
        .findFirst();
  }

}
