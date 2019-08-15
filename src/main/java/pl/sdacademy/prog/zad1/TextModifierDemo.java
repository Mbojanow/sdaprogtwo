package pl.sdacademy.prog.zad1;

public class TextModifierDemo {

    public static void main(String[] args) {

        final FileContentSupplier fileContentSupplier = new FileContentSupplier();
        final ModificationType modificationType = ModificationType.valueOf(args[0]);
        final String fileToModify = args[1];
        final String textToModify = fileContentSupplier.getContentAsString(fileToModify);
        final TextModificationStrategy strategy = new ModificationStrategyProvider().provide(modificationType);
        final TextModifier textModifier = new TextModifier(strategy);
        final String modified = textModifier.modify(textToModify);
        System.out.println(modified);
    }
}
