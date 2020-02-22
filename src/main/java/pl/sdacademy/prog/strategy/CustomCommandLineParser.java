package pl.sdacademy.prog.strategy;

import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CustomCommandLineParser {

  private static final String FILE_OPTION_NAME = "f";
  private static final String TYPE_OPTION_NAME = "t";
  private static final char VALUE_SEPARATOR = '=';

  private CommandLine parsedArguments;

  public void parse(final String[] args) throws ParseException {
    final CommandLineParser parser = new DefaultParser();
    parsedArguments = parser.parse(createOptionsDefinitions(), args);
  }

  public Optional<String> getTypeOptionValue() {
    if (parsedArguments == null) {
      return Optional.empty();
    }
    return Optional.of(parsedArguments.getOptionValue(TYPE_OPTION_NAME));
  }

  public Optional<String> getFileOptionValue() {
    return Optional.ofNullable(parsedArguments)
        .map(args -> args.getOptionValue(FILE_OPTION_NAME));
  }

  private Options createOptionsDefinitions() {
    return new Options()
        .addOption(buildConversionTypeOption())
        .addOption(buildSourceFileTypeOption());
  }

  private Option buildSourceFileTypeOption() {
    return Option.builder()
        .required()
        .longOpt(FILE_OPTION_NAME)
        .valueSeparator(VALUE_SEPARATOR)
        .hasArg()
        .argName(FILE_OPTION_NAME)
        .desc("Source file path for text conversion")
        .build();
  }

  private Option buildConversionTypeOption() {
    return Option.builder()
        .required()
        .longOpt(TYPE_OPTION_NAME)
        .valueSeparator(VALUE_SEPARATOR)
        .hasArg()
        .argName(TYPE_OPTION_NAME)
        .desc("Conversion type for strategy. Available types are CAMEL_CASE, KEBAB_CASE, COMPRESS, NONE")
        .build();
  }

}
