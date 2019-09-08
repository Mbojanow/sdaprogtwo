package pl.sdacademy.prog.day6.strategy;

public class NoOpModicationStrategy implements TextModificationStrategy {
  @Override
  public void process(final String text) {
    System.out.println(text);
  }
}
