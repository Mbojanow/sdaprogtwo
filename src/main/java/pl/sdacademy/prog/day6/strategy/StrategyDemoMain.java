package pl.sdacademy.prog.day6.strategy;

public class StrategyDemoMain {

  public static void main(String[] args) {
    final String type = args[0];
    final String toModify = args[1];

    final TextModificationStrategyProvider provider = new TextModificationStrategyProvider();

    final TextModificationStrategy strategyByType = provider.getStrategyByType(type);

    strategyByType.process(toModify);
  }
}
