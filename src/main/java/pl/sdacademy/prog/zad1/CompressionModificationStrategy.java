package pl.sdacademy.prog.zad1;

import static java.util.Objects.isNull;

public class CompressionModificationStrategy implements TextModificationStrategy {

    private static CompressionModificationStrategy INSTANCE;

    private CompressionModificationStrategy() {
    }

    public static CompressionModificationStrategy getInstance() {
        if (isNull(INSTANCE)) {
            INSTANCE = new CompressionModificationStrategy();
        }
        return INSTANCE;
    }


    @Override
    public String modify(final String toModify) {
        final StringBuilder outputTextBuilder = new StringBuilder(toModify.length());
        boolean nextCharUppercase = false;
        for (final char c: toModify.toCharArray()) {
            if (isSpaceCharacter(c)) {
                nextCharUppercase = true;
                continue;
            }

            if (nextCharUppercase && Character.isAlphabetic(c)) {
                outputTextBuilder.append(Character.toUpperCase(c));
            } else {
                outputTextBuilder.append(c);
            }
            nextCharUppercase = false;

        }

        return outputTextBuilder.toString().trim();
    }

    private boolean isSpaceCharacter(final char character) {
        return character == ' ';
    }
}
