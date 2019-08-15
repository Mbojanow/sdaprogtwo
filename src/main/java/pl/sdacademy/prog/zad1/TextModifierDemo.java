package pl.sdacademy.prog.zad1;

import org.apache.commons.cli.ParseException;

public class TextModifierDemo {

    public static void main(String[] args) throws ParseException {
        final FileContentSupplier fileContentSupplier = new FileContentSupplier();
        final ModificationStrategyProvider strategyProvider = new ModificationStrategyProvider();
        final CustomArgumentsParser customArgumentsParser = new CustomArgumentsParser(args);
        final TextFromFileModificationFacade facade = new TextFromFileModificationFacade(fileContentSupplier, strategyProvider, customArgumentsParser);
        facade.process();
    }
}
