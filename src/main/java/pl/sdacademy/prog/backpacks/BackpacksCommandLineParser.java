package pl.sdacademy.prog.backpacks;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import pl.sdacademy.prog.stra.GenericException;

public class BackpacksCommandLineParser {

  private static final String BACKPACKS_ARG_NAME = "n";
  private static final String INPUT_FILE_ARG_NAME = "f";
  private static final String OUTPUT_DIR_ARG_NAME = "o";
  private static final char SEPARATOR = '=';

  private CommandLine commandLine;

  public void parse(final String[] args) {
    final CommandLineParser commandLineParser = new DefaultParser();
    try {
      commandLine = commandLineParser.parse(createOptions(), args);
    } catch (final ParseException e) {
      throw new GenericException("Could not parse command line. "
          + e.getMessage(), e);
    }
  }

  public Integer getBackpacksArgValue() {
    return Integer.parseInt(commandLine.getOptionValue(BACKPACKS_ARG_NAME));
  }

  public String getInputFileArgValue() {
    return commandLine.getOptionValue(INPUT_FILE_ARG_NAME);
  }

  public String getOutputFileArgValue() {
    return commandLine.getOptionValue(OUTPUT_DIR_ARG_NAME);
  }

  public Options createOptions() {
    return new Options()
        .addOption(createBackpacksNumOption())
        .addOption(createInputFileOption())
        .addOption(createOutputfileOption());
  }

  private Option createBackpacksNumOption() {
    return createMandatoryOptionArgument(BACKPACKS_ARG_NAME);
  }

  private Option createMandatoryOptionArgument(final String argName) {
    return Option.builder()
        .hasArg()
        .argName(argName)
        .longOpt(argName)
        .valueSeparator(SEPARATOR)
        .required()
        .build();
  }

  private Option createInputFileOption() {
    return createMandatoryOptionArgument(INPUT_FILE_ARG_NAME);
  }

  private Option createOutputfileOption() {
    return createMandatoryOptionArgument(OUTPUT_DIR_ARG_NAME);
  }


}
