package pl.sdacademy.prog.zad1;

public class TextFromFileModificationFacade {

    private final FileContentSupplier fileContentSupplier;
    private final ModificationStrategyProvider modificationStrategyProvider;

    public TextFromFileModificationFacade(final FileContentSupplier fileContentSupplier, final ModificationStrategyProvider modificationStrategyProvider) {
        this.fileContentSupplier = fileContentSupplier;
        this.modificationStrategyProvider = modificationStrategyProvider;
    }

    public void process(final String[] args) {
        final ModificationType modificationType = ModificationType.valueOf(args[0]);
        final String fileToModify = args[1];
        final String textToModify = fileContentSupplier.getContentAsString(fileToModify);
        final TextModificationStrategy strategy = modificationStrategyProvider.provide(modificationType);
        final TextModifier textModifier = new TextModifier(strategy);
        final String modified = textModifier.modify(textToModify);
        System.out.println(modified);
    }
}
