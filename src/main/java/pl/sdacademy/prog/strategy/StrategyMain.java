package pl.sdacademy.prog.strategy;

public class StrategyMain {
  public static void main(String[] args) {
    // "/Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources/text" KEBAB_CASE --- STARE PODEJŚCIE
    // -f="/Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources/text" -t=KEBAB_CASE
    // -t=KEBAB_CASE -f="/Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources/text"
    final CustomCommandLineParser customCommandLineParser = new CustomCommandLineParser();
    final FileContentReader fileContentReader = new FileContentReader();
    final TextModificationStrategyProvider provider = new TextModificationStrategyProvider();
    final TextModificationFacade textModificationFacade = new TextModificationFacade(customCommandLineParser, fileContentReader, provider);
    textModificationFacade.process(args);
  }
}
