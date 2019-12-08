package pl.sdacademy.prog.strategy;

public class CompressionConversionStrategy extends TextConversionStrategyTemplate {
  @Override
  protected boolean handleNonAlphanumericChar(final char c, final StringBuilder builder) {
    return true;
  }
}
