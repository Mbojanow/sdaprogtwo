package pl.sdacademy.prog.zad1;

public class ModificationStrategyProvider {

    public TextModificationStrategy provide(final ModificationType modificationType) {
        switch(modificationType) {
            case TEXT_COMPRESS:
                return CompressionModificationStrategy.getInstance();
            case KEBAB_CASE:
                return KebabCaseModificationStrategy.INSTANCE;
            case CAMEL_CASE:
                return CamelCaseModificationStrategy.getInstance();
            default:
                return NoopModificationStrategy.getInstance();
        }
    }
}
