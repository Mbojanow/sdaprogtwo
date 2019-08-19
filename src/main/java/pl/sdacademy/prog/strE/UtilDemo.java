package pl.sdacademy.prog.strE;

import java.util.Arrays;
import java.util.List;

public class UtilDemo {

    public static void main(String[] args) {

        final List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        Util.toSingleList(listOfLists).forEach(System.out::println);

        Util.toListToItsSum(listOfLists).forEach((k, v) -> System.out.println(k + " " + v));

        final List<List<String>> listOfWordLists = Arrays.asList(
                Arrays.asList("First", "words of wisdom ", "hello", ""),
                Arrays.asList("Second", "row")
        );

        System.out.println(Util.toSentence(listOfWordLists));


        Util.toWordStatistics("This is the best the best all of you si the qwerty").forEach((k, v) -> System.out.println(k + " " + v));
    }
}
