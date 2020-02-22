package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.ParseException;

public class StrategyDemo {
  public static void main(String[] args) {

    // STARE PRZYKŁADY BEZ COMMAND LINE PARSERA
    //"this shoule be -kebab cased" KEBAB_CASE
    //"this shoule be -kebab cased" COMPRESSION

    //-f=/Users/michalbojanowski/work/sdaprogtwo/src/main/resources/input.txt -t=CAMEL_CASE
    final CustomCommandLineParser parser = new CustomCommandLineParser();
    final FileContentReader reader = new FileContentReader();
    final TextModificationStrategySelector selector = new TextModificationStrategySelector();
    final TextModificationProcessFacade facade = new TextModificationProcessFacade(
        parser, reader, selector);
    try {
      System.out.println(facade.process(args));
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      return;
    }


  }
}
