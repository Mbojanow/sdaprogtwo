package pl.sdacademy.prog.strategy;

public class NoOpModificationStrategy implements TextModificationStrategy {

  @Override
  public String modify(final String input) {
    return input;
  }
}
