package pl.sdacademy.prog.zad1;

public class TextModifierDemo {

    public static void main(String[] args) {
        final ModificationType modificationType = ModificationType.valueOf(args[0]);
        final String textToModify = args[1];

        final TextModificationStrategy strategy = new ModificationStrategyProvider().provide(modificationType);
        final TextModifier textModifier = new TextModifier(strategy);
        final String modified = textModifier.modify(textToModify);
        System.out.println(modified);
    }
}
