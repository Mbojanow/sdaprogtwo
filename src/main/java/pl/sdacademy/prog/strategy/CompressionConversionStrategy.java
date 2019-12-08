package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// LAZY
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompressionConversionStrategy extends TextConversionStrategyTemplate {

  private static CompressionConversionStrategy instance;

  public static CompressionConversionStrategy getInstance() {
    if (instance == null) {
      instance = new CompressionConversionStrategy();
    }
    return instance;
  }

  @Override
  protected boolean handleNonAlphanumericChar(final char c, final StringBuilder builder) {
    return true;
  }
}
