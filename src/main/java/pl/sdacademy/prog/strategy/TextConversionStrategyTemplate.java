package pl.sdacademy.prog.strategy;

public abstract class TextConversionStrategyTemplate implements TextConversionStrategy {

  @Override
  public String modify(final String textToModify) {
    final StringBuilder outputBuilder = new StringBuilder(textToModify.length());
    boolean shouldApplyActionBeforeNextWord = false;
    for (final Character c : textToModify.trim().toCharArray()) {
      if (Character.isLetterOrDigit(c) || c == '\n') {
        shouldApplyActionBeforeNextWord = handleAlphanumericChar(c,
            shouldApplyActionBeforeNextWord, outputBuilder);
      } else {
        shouldApplyActionBeforeNextWord = handleNonAlphanumericChar(c, outputBuilder);
      }
    }
    return outputBuilder.toString();
  }

  protected boolean handleAlphanumericChar(final char c,
                                           final boolean shouldApplyActionBeforeNextWord,
                                           final StringBuilder builder) {
    if (shouldApplyActionBeforeNextWord) {
      builder.append(Character.toUpperCase(c));
    } else {
      builder.append(c);
    }
    return false;
  }

  protected abstract boolean handleNonAlphanumericChar(final char c, final StringBuilder builder);
}
