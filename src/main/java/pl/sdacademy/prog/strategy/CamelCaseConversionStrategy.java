package pl.sdacademy.prog.strategy;

public class CamelCaseConversionStrategy extends TextConversionStrategyTemplate {
  @Override
  protected boolean handleNonAlphanumericChar(final char c, final StringBuilder builder) {
    if (!Character.isWhitespace(c)) {
      builder.append(c);
    }
    return true;
  }
}
