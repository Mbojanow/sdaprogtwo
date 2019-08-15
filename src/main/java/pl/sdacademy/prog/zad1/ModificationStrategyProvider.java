package pl.sdacademy.prog.zad1;

public class ModificationStrategyProvider {

    public TextModificationStrategy provide(final ModificationType modificationType) {
        switch(modificationType) {
            case TEXT_COMPRESS:
                return new CompressionModificationStrategy();
            case KEBAB_CASE:
                return new KebabCaseModificationStrategy();
            case CAMEL_CASE:
                return new CamelCaseModificationStrategy();
            default:
                return new NoopModificationStrategy();
        }
    }
}
