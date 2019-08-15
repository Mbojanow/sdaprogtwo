package pl.sdacademy.prog.zad1;

public class NoopModificationStrategy implements TextModificationStrategy {

    private static NoopModificationStrategy INSTANCE;

    private NoopModificationStrategy() {
    }

    public static NoopModificationStrategy getInstance() {
        if (INSTANCE == null) {
            synchronized (NoopModificationStrategy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NoopModificationStrategy();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String modify(final String toModify) {
        return toModify.trim();
    }
}
