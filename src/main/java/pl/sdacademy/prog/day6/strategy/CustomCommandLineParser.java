package pl.sdacademy.prog.day6.strategy;

import static java.util.Objects.isNull;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CustomCommandLineParser {

  // wykorzystywane obiekty:
  // Options -> do stworzenia listy dostępnych opcji w lini komend programu
  // Option -> ustawienia dotyczące pojedyczej opcji
  // CommandLineParser - obiekt przetwarzający listę argumentów programu (typu String[] args) na czytelny dla nas format
  // CommandLine - przetworzone argumenty -> getOptionValue daje nam wartość argumentu np. dla
  // -t=KEBAB_CASE dostajemy KEBAB_CASE

  private static final String MODIFICATION_TYPE_ARG = "t";
  private static final String FILE_PATH_ARG = "f";
  private static final Character VALUE_SEPARATOR = '=';

  private CommandLine parsedArgs;

  public void parseArguments(String[] args) {
    CommandLineParser parser = new DefaultParser();
    try {
      parsedArgs = parser.parse(buildAllOptions(), args);
    } catch (final ParseException exp) {
      throw new SdaException("Failed to parse arguments correctly", exp);
    }
  }

  public String getModificationTypeArgValue() {
    validateArgumentsParsed();
    return parsedArgs.getOptionValue(MODIFICATION_TYPE_ARG);
  }

  private void validateArgumentsParsed() {
    if (isNull(parsedArgs)) {
      throw new SdaException("Need to parse arguments before getting their value");
    }
  }

  public String getFilePathArgValue() {
    validateArgumentsParsed();
    return parsedArgs.getOptionValue(FILE_PATH_ARG);
  }


  private Options buildAllOptions() {
    return new Options()
        .addOption(buildModificationTypeOption())
        .addOption(buildFilePathOption());
  }

  private Option buildModificationTypeOption() {
    return buildRequiredOptionWithName(MODIFICATION_TYPE_ARG);
  }

  private Option buildFilePathOption() {
    return buildRequiredOptionWithName(FILE_PATH_ARG);
  }

  private Option buildRequiredOptionWithName(final String argName) {
    return Option.builder()
        .longOpt(argName)
        .hasArg(true)
        .required()
        .valueSeparator(VALUE_SEPARATOR)
        .build();
  }
}
