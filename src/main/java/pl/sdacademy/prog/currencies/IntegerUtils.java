package pl.sdacademy.prog.currencies;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerUtils {

  public static List<Integer> toSingleList(final List<List<Integer>> listOfLists) {
    return listOfLists.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  // z listy list intow -> mape: na listy przypisze sume jej elementow [tylko gdy lista ma parzysty element
  public Map<List<Integer>, Integer> getListsToSumOfElementsWithEvenNumber(final List<List<Integer>> listOfList) {
    return listOfList.stream()
        .filter(this::hasAnyEvenNumber)
        .collect(Collectors.toMap(Function.identity(), this::sum));
  }

  // w streamie List<Integer>

  // toMap(jak stworzyć klucz z aktualnego elemntu streamu, jak stworzyć wartość z aktualnego elemntu streamu)
  // 1. toMap(List<Integer>: list -> list : Function.identity(), ......
  // 2. toMap(...., list -> sum(list)

  //Collectors.toMap(Function.identity(), list -> list.stream().mapToInt(elem -> elem).sum())

  private boolean hasAnyEvenNumber(List<Integer> numbers) {
    return numbers.stream().anyMatch(elem -> elem % 2 == 0);
  }

  private int sum(List<Integer> ints) {
    return ints.stream().mapToInt(elem -> elem).sum();
  }

  // stworzyc zdanie -> połaczyć wyrazy JEDNA spacja. wszystkie litery powinny być wielkie. na końcu kropka
  // "  no siema     "
  // ""
  // joining "No", "", "siema" -> "No  siema"
  public String toSentence(final List<List<String>> listOfLists) {
    return listOfLists.stream()
        .flatMap(Collection::stream)
        .map(String::trim)
        .filter(String::isEmpty)
        .map(String::toUpperCase)
        .collect(Collectors.joining(" ", "", "."));
  }

  public static Map<String, Integer> toWordsUsage(String sentence){
    return Arrays.stream(sentence.split(" ")) // String[] -> Arrays.stream(String[]) -> Stream<String>
        .map(String::toLowerCase)
        .map(IntegerUtils::removeCommasAndSemicolons) // "siema -> siema, "do," -> "do", "koniec." -> "koniec"
        // No siema no siema co jest. ->
        // ["no", ["no", "no]]                   -> ["no", 2]
        // ["siema", ["siema", "siema"]]          -> ["siema, 2"]
        // ["co", ["co"]]                        -> ["co", 1]
        // ["jest", ["jest"]]                    -> ["jest", 1]
        .collect(Collectors.groupingBy(word -> word)) // Function.identity()
        .entrySet().stream()
        //Map.Entry::getKey -> ["jest", ["jest"]]  -> "jest" jak klucz
        //entry -> entry.getValue().size() -> ["jest", ["jest"]] -> ["jest"].size() = 1
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
  }
  private static String removeCommasAndSemicolons (String word){
    if (word.endsWith(",") || word.endsWith(";") || word.endsWith(".")){
      return word.substring(0, word.length()-1);
    }
    return word;
  }

}
