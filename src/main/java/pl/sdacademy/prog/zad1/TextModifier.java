package pl.sdacademy.prog.zad1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextModifier {

    private final TextModificationStrategy textModificationStrategy;

    public TextModifier(final TextModificationStrategy textModificationStrategy) {
        this.textModificationStrategy = textModificationStrategy;
    }

    public String modify(final String toModify) {
        log.info("Modifying text ", toModify);
        return textModificationStrategy.modify(toModify);
    }
}
