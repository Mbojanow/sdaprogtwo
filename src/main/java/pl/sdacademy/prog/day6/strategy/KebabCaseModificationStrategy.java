package pl.sdacademy.prog.day6.strategy;

import java.util.stream.Collectors;
import java.util.stream.Stream;


//EAGER
public class KebabCaseModificationStrategy implements TextModificationStrategy {

  private static final KebabCaseModificationStrategy instance = new KebabCaseModificationStrategy();

  public static KebabCaseModificationStrategy getInstance() {
    return instance;
  }

  private KebabCaseModificationStrategy() {

  }

  @Override
  public void process(final String text) {
    final String kebabCaseString = Stream.of(text.trim().toLowerCase().split(" "))
        .filter(str -> !str.isEmpty())
        .collect(Collectors.joining("-"));
    System.out.println(kebabCaseString);
  }
}
