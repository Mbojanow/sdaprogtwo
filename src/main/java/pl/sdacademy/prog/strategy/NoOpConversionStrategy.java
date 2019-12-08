package pl.sdacademy.prog.strategy;

public class NoOpConversionStrategy implements TextConversionStrategy {

  @Override
  public String modify(final String textToModify) {
    return textToModify;
  }
}
