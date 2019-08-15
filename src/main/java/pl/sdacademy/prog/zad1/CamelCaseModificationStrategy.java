package pl.sdacademy.prog.zad1;

public class CamelCaseModificationStrategy implements TextModificationStrategy {

    @Override
    public String modify(final String toModify) {
        final StringBuilder outputTextBuilder = new StringBuilder(toModify.length());
        boolean nextCharUppercase = true;
        for (final char c: toModify.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                nextCharUppercase = true;
                if (c == ' ') {
                    continue;
                }
            }

            if (nextCharUppercase && Character.isAlphabetic(c)) {
                outputTextBuilder.append(Character.toUpperCase(c));
                nextCharUppercase = false;
            } else {
                outputTextBuilder.append(c);
            }
        }

        return outputTextBuilder.toString().trim();
    }
}
