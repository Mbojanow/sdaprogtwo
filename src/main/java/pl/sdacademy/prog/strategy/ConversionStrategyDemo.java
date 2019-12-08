package pl.sdacademy.prog.strategy;

public class ConversionStrategyDemo {
  //COMPRESSION "dsa  huieqwewq0 dqweSDdas -ASDwqe"
  public static void main(String[] args) {
    final ConversionType type = ConversionType.valueOf(args[0]);
    final String toModify = args[1];

    final ConversionStrategyProvider strategyProvider = new ConversionStrategyProvider();
    final TextConversionStrategy strategy = strategyProvider.getStrategy(type);
    final String modified = strategy.modify(toModify);
    System.out.println(modified);
  }
}
