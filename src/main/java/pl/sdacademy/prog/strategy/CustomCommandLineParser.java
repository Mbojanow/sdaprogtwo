package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CustomCommandLineParser {

  // 1 zdefiniować jak wyglada opcja sciezki do plik -> "-f"
  // 2. zdefiniować jak wygląda opcja typu modyfikacji -> "-t"
  // 3. połączyć te 2 opcje wyżej -> Options()
  // 4. stworzyć DefaultParser -> parse(opcje z punktu 3, argumenty wejśćiowe)
  // 5. możliwośc pobrania wartości -f i -t

  private static final String TYPE_ARGUMENT_NAME = "t";
  private static final String FILE_PATH_ARGUMENT_NAME = "f";
  private static final char VALUE_SEPARATOR = '=';

  private CommandLine commandLine;

  public void parse(final String[] args) throws ParseException {
    CommandLineParser commandLineParser = new DefaultParser();
    commandLine = commandLineParser.parse(createOptions(), args);
  }

  public String getFilePath() {
    throwInArgumentsNotParsed();
    return commandLine.getOptionValue(FILE_PATH_ARGUMENT_NAME);
  }

  private void throwInArgumentsNotParsed() {
    if (commandLine == null) {
      throw new StrategyException("Has to parse arguments before accessing values");
    }
  }

  public String getModificationType() {
    throwInArgumentsNotParsed();
    return commandLine.getOptionValue(TYPE_ARGUMENT_NAME);
  }

  private Options createOptions() {
    return new Options()
        .addOption(createFilePathOption())
        .addOption(createTypeOption());
  }

  private Option createFilePathOption() {
    return createMandatoryOptionWithValue(FILE_PATH_ARGUMENT_NAME);
  }

  private Option createTypeOption() {
    return createMandatoryOptionWithValue(TYPE_ARGUMENT_NAME);
  }

  private Option createMandatoryOptionWithValue(final String name) {
    return Option.builder()
        .argName(name)
        .longOpt(name)
        .required()
        .valueSeparator(VALUE_SEPARATOR)
        .hasArg()
        .build();
  }


}
