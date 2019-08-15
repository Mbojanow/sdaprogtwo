package pl.sdacademy.prog.zad1;

public class NoopModificationStrategy implements TextModificationStrategy {
    @Override
    public String modify(final String toModify) {
        return toModify.trim();
    }
}
