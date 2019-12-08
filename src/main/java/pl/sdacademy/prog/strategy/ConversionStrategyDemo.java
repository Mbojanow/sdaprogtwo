package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ConversionStrategyDemo {
  //-t=KEBAB_CASE -f=/Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/sometext  public static void main(String[] args) {
  public static void main(String[] args) {
    CustomCommandLineParser parser = new CustomCommandLineParser();
    parser.parse(args);
    final ConversionType type = parser.getConversionTypeArgValue();
    final String path = parser.getFilePathArgValue();
    final FileContentProvider fileContentProvider = new FileContentProvider();
    final String toModify = fileContentProvider.readContent(path);

    final ConversionStrategyProvider strategyProvider = new ConversionStrategyProvider();
    final TextConversionStrategy strategy = strategyProvider.getStrategy(type);
    final String modified = strategy.modify(toModify);
    System.out.println(modified);

  }
}
