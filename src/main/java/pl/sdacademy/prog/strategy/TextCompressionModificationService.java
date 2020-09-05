package pl.sdacademy.prog.strategy;

//singleton enum
public enum TextCompressionModificationService implements TextModificationService {
  INSTANCE;

  @Override
  public String modify(final String toModify) {
    final char[] chars = toModify.trim().toCharArray();
    final StringBuilder sb = new StringBuilder(toModify.length());
    boolean isNextCharUpperCase = false;
    for (final char ch : chars) {
      if (Character.isAlphabetic(ch)) {
        if (isNextCharUpperCase) {
          sb.append(Character.toUpperCase(ch));
          isNextCharUpperCase = false;
        } else {
          sb.append(ch);
        }
      } else {
        isNextCharUpperCase = true;
      }
    }
    return sb.toString();
  }
}
