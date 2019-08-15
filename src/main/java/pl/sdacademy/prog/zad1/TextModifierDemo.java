package pl.sdacademy.prog.zad1;

public class TextModifierDemo {

    public static void main(String[] args) {
        final FileContentSupplier fileContentSupplier = new FileContentSupplier();
        final ModificationStrategyProvider strategyProvider = new ModificationStrategyProvider();
        final TextFromFileModificationFacade facade = new TextFromFileModificationFacade(fileContentSupplier, strategyProvider);
        facade.process(args);
    }
}
