package pl.sdacademy.prog.stre;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

  public List<Integer> toSingleList(List<List<Integer>> listOfList) {
    return listOfList.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public Map<List<Integer>, Integer> toListStatistics(final List<List<Integer>> listOfList) {
    return listOfList.stream()
        .filter(this::hasAnyEvenElement)
        .collect(Collectors.toMap(Function.identity(), this::sumListElements));
  }

  private boolean hasAnyEvenElement(final List<Integer> values) {
    return values.stream().anyMatch(elem -> elem % 2 == 0);
  }

  private Integer sumListElements(final List<Integer> values) {
    return values.stream().mapToInt(x -> x).sum();
  }

  public String createSentence(final List<List<String>> listsOfWords) {
    return listsOfWords.stream()
        .flatMap(Collection::stream)
        .filter(elem -> !elem.isBlank())
        .map(elem -> elem.trim().toUpperCase())
        .collect(Collectors.joining(" ")) + ".";
  }

  public Map<String, Integer> toUsageStatistics(final String sentence) {
    return Stream.of(sentence.split(" "))
        .collect(Collectors.groupingBy(Function.identity()))
        .entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
  }
}
