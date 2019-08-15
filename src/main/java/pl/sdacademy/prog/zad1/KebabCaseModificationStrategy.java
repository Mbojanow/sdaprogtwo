package pl.sdacademy.prog.zad1;

public class KebabCaseModificationStrategy implements TextModificationStrategy {

    @Override
    public String modify(final String toModify) {
        final StringBuilder outputTextBuilder = new StringBuilder(toModify.length());
        boolean isWhiteSpaceStream = false;
        for (final char c: toModify.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (isWhiteSpaceStream) {
                    outputTextBuilder.append('-');
                    isWhiteSpaceStream = false;
                }
                outputTextBuilder.append(Character.toLowerCase(c));
            } else {
                isWhiteSpaceStream = true;
            }
        }

        return outputTextBuilder.toString();
    }
}
