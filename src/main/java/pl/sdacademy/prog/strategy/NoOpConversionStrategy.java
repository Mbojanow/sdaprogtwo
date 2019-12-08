package pl.sdacademy.prog.strategy;

public enum NoOpConversionStrategy implements TextConversionStrategy {
  INSTANCE;

  @Override
  public String modify(final String textToModify) {
    return textToModify;
  }
}
