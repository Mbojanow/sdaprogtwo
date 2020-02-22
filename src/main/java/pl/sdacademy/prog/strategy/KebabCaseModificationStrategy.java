package pl.sdacademy.prog.strategy;

public class KebabCaseModificationStrategy implements TextModificationStrategy {

  @Override
  public String modify(final String input) {
    final StringBuilder output = new StringBuilder(input.length());
    boolean shouldAddDash = false;
    for (final char c: input.trim().toCharArray()) {
      if (!Character.isWhitespace(c)) {
        if (shouldAddDash && c != '-') {
          output.append('-');
          shouldAddDash = false;
        }
        if (c == '-') {
          shouldAddDash = false;
        }
        output.append(Character.toLowerCase(c));
      } else {
        shouldAddDash = true;
      }
    }
    return output.toString();
  }
}
