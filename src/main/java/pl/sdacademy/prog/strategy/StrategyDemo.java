package pl.sdacademy.prog.strategy;

public class StrategyDemo {
  public static void main(String[] args) {
    //"this shoule be -kebab cased" KEBAB_CASE
    //"this shoule be -kebab cased" COMPRESSION
    final String filePath = args[0];
    final String modificationType = args[1];
    final TextModificationStrategySelector selector = new TextModificationStrategySelector();
    final TextModificationStrategy strategy = selector.getTextModificationStrategy(modificationType);
    final FileContentReader fileContentReader = new FileContentReader();
    final String textToModify = fileContentReader.readContent(filePath);
    final String output = strategy.modify(textToModify);
    System.out.println(output);
  }
}
