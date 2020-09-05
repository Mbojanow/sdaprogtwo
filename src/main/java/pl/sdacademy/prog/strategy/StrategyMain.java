package pl.sdacademy.prog.strategy;

public class StrategyMain {
  public static void main(String[] args) {
    final String toModify = "this -will Be KEBAB-  cased";
    // soLid
    final TextModificationService textModificationService = new KebabCaseModificationStrategy();
    System.out.println(textModificationService.modify(toModify));
  }
}
