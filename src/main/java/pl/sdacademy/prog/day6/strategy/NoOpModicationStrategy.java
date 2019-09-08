package pl.sdacademy.prog.day6.strategy;

import static java.util.Objects.isNull;

// LAZY
public class NoOpModicationStrategy implements TextModificationStrategy {

  private static NoOpModicationStrategy instance = new NoOpModicationStrategy();

  public static NoOpModicationStrategy getInstance() {
    if (isNull(instance)) {
      instance = new NoOpModicationStrategy();
    }
    return instance;
  }

  private NoOpModicationStrategy() {
  }

  @Override
  public void process(final String text) {
    System.out.println(text);
  }
}
