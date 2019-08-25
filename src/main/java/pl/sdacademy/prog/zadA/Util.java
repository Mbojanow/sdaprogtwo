package pl.sdacademy.prog.zadA;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {

  public static List<Integer> toSingleList(final List<List<Integer>> listOfLists) {
    return listOfLists.stream()
        .flatMap(list -> list.stream())
        .collect(Collectors.toList());
  }

  public static Map<List<Integer>, Integer> toListWithEvenElementToItsSum(final List<List<Integer>> listOfLists) {
    return listOfLists.stream()
        .filter(Util::containsEvenElement)
        .collect(Collectors.toMap(list -> list, list -> list.stream().collect(Collectors.summingInt(i -> i))));
  }

  private static boolean containsEvenElement(final List<Integer> values) {
//    values.stream()
//        .filter(x -> x % 2 == 0)
//        .findAny().isPresent();

    return values.stream()
        .anyMatch(x -> x % 2 == 0);
  }

  public static String formSentenceOf(final List<List<String>> listOfLists) {
    return listOfLists.stream()
        .flatMap(Collection::stream)
        .map(String::trim)
        .filter(elem -> !elem.isEmpty())
        .collect(Collectors.joining(" ")).toUpperCase() + ".";
  }
}
