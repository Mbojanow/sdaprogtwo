package pl.sdacademy.prog.day6.strategy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KebabCaseModificationStrategy implements TextModificationStrategy {

  @Override
  public void process(final String text) {
    final String kebabCaseString = Stream.of(text.trim().toLowerCase().split(" "))
        .filter(str -> !str.isEmpty())
        .collect(Collectors.joining("-"));
    System.out.println(kebabCaseString);
  }
}
