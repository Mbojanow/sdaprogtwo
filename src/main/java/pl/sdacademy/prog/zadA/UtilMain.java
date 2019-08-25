package pl.sdacademy.prog.zadA;

import java.util.Arrays;
import java.util.stream.Stream;

public class UtilMain {

  public static void main(String[] args) {

    Dummy dummyA = new Dummy("Andrzej", 13, Arrays.asList(2, 2, 3, 4));
    Dummy dummyB = new Dummy("Michal", 15, Arrays.asList(4, 1, 1, 2));
    Dummy dummyC = new Dummy("Karol", 22, Arrays.asList(3, 4, 5, 7));

    Stream<Dummy> dummyStream = Stream.of(dummyA, dummyB, dummyC);


    dummyStream.flatMap(dummy -> dummy.getGrades().stream()); //Stream<Integer> 2, 2, 3, 4, 4, 1, 1, 2, 3 ,4 ,5 ,7

  }
}
