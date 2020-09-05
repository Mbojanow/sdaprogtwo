package pl.sdacademy.prog.strategy;

public class CamelCaseModificationService implements TextModificationService {

  @Override
  public String modify(final String toModify) { // ja
    final String trimmedText = toModify.trim();
    boolean isNextAlphabeticCharUppercase = false;
    boolean isFirstChar = true;
    final StringBuilder sb = new StringBuilder(trimmedText.length());
    for (final char ch : trimmedText.toCharArray()) {
      if (isFirstChar) {
        sb.append(Character.toLowerCase(ch)); // j
        isFirstChar = false;
        continue;
      }
      if (Character.isAlphabetic(ch)) {
        if (isNextAlphabeticCharUppercase) {
          sb.append(Character.toUpperCase(ch));
          isNextAlphabeticCharUppercase = false;
        } else {
          sb.append(ch); // j
        }
      } else {
        isNextAlphabeticCharUppercase = true;
        if (ch != ' ') {
          sb.append(ch);
        }
      }
    }
    return sb.toString();
  }
}
