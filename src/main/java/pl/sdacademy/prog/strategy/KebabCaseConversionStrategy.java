package pl.sdacademy.prog.strategy;

public class KebabCaseConversionStrategy extends TextConversionStrategyTemplate {

  @Override
  protected boolean handleNonAlphanumericChar(final char c, final StringBuilder builder) {
    return true;
  }

  @Override
  protected boolean handleAlphanumericChar(final char c, final boolean shouldApplyActionBeforeNextWord, final StringBuilder builder) {
    if (shouldApplyActionBeforeNextWord) {
      builder.append('-');
    }
    builder.append(Character.toLowerCase(c));
    return false;
  }
}
