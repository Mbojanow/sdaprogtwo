package pl.sdacademy.prog.streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

  public List<Integer> mergeToSingleList(final List<Dummy> dummies) {
    return dummies.stream()
        // "połącz stream streamów w pojedynczy stream"
        .flatMap(dummy -> dummy.getInts().stream())
        .collect(Collectors.toList());
  }

  public Map<List<Integer>, Integer> sumElementsWithAtLeastOneSingleEven(
      final List<Dummy> dummies) {
    return dummies.stream()
        .filter(dummy -> hasAnyEvenElement(dummy.getInts()))
        .collect(Collectors.toMap(Dummy::getInts,
            dummy -> sumAllElements(dummy.getInts())));

//    dummies.stream()
//        .filter(dummy -> hasAnyEvenElement(dummy.getInts()))
//        .map(Dummy::getInts)
//        //lst -> lst -> indetity
//        .collect(Collectors.toMap(Function.identity(), this::sumAllElements));

  }

  private boolean hasAnyEvenElement(final List<Integer> ints) {
    return ints.stream().anyMatch(elem -> elem % 2 == 0);
  }

  private Integer sumAllElements(final List<Integer> ints) {
        // zwykły stream
    return ints.stream()
        // IntStream
        .mapToInt(elem -> elem)
        .sum();
  }

  public String createSentence(final List<List<String>> listOfLists) {
    return listOfLists.stream()
        //lst -> lst.stream()
        .flatMap(Collection::stream)
        .filter(elem -> elem.trim().length() > 0)
        .collect(Collectors.joining(" ")) + ".";
  }

  public Map<String, Integer> getWordStatistics(final String sentence) {
    return Stream.of(sentence.split(" "))
        //x -> x to samo co Function.identity()
        .collect(Collectors.groupingBy(Function.identity()))
        .entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
  }

}
