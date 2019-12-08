package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// EAGER
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CamelCaseConversionStrategy extends TextConversionStrategyTemplate {

  private static final CamelCaseConversionStrategy INSTANCE = new CamelCaseConversionStrategy();

  public static CamelCaseConversionStrategy getInstance() {
    return INSTANCE;
  }

  @Override
  protected boolean handleNonAlphanumericChar(final char c, final StringBuilder builder) {
    if (!Character.isWhitespace(c)) {
      builder.append(c);
    }
    return true;
  }
}
