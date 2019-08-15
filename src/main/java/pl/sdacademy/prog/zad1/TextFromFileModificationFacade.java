package pl.sdacademy.prog.zad1;

public class TextFromFileModificationFacade {

    private final FileContentSupplier fileContentSupplier;
    private final ModificationStrategyProvider modificationStrategyProvider;
    private final CustomArgumentsParser customArgumentsParser;

    public TextFromFileModificationFacade(final FileContentSupplier fileContentSupplier, final ModificationStrategyProvider modificationStrategyProvider, final CustomArgumentsParser customArgumentsParser) {
        this.fileContentSupplier = fileContentSupplier;
        this.modificationStrategyProvider = modificationStrategyProvider;
        this.customArgumentsParser = customArgumentsParser;
    }

    public void process() {
        final ModificationType modificationType = customArgumentsParser.getModificationType();
        final String fileToModify = customArgumentsParser.getFilePath();
        final String textToModify = fileContentSupplier.getContentAsString(fileToModify);
        final TextModificationStrategy strategy = modificationStrategyProvider.provide(modificationType);
        final TextModifier textModifier = new TextModifier(strategy);
        final String modified = textModifier.modify(textToModify);
        System.out.println(modified);
    }
}
