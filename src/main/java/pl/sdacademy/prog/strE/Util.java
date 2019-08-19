package pl.sdacademy.prog.strE;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Util {

    public static List<Integer> toSingleList(final List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static Map<List<Integer>, Integer> toListToItsSum(final List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .filter(list -> list.stream()
                        .anyMatch(elem -> elem % 2 == 0))
                .collect(Collectors.toMap(elem -> elem, elem -> (Integer) elem.stream()
                .mapToInt(val -> val).sum()));
    }

    public static String toSentence(final List<List<String>> listsOfWords) {
        return listsOfWords.stream()
                .flatMap(Collection::stream)
                .filter(str -> !str.isEmpty())
                .map(String::trim)
                .collect(Collectors.joining(" ")) + ".";
    }

    public static Map<String, Long> toWordStatistics(final String sentence) {
        return Stream.of(sentence.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), counting()));
    }




}
