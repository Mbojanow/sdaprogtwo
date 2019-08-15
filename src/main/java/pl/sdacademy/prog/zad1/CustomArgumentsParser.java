package pl.sdacademy.prog.zad1;

import org.apache.commons.cli.*;

public class CustomArgumentsParser {

    private static final String TYPE_ARG = "t";
    private static final String FILE_ARG = "f";
    private static final char VALUE_SEPARATOR = '=';

    private CommandLine commandLine;

    public CustomArgumentsParser(final String[] args) throws ParseException {
        parse(args);
    }

    public ModificationType getModificationType() {
        return ModificationType.valueOf(commandLine.getOptionValue(TYPE_ARG));
    }

    public String getFilePath() {
        return commandLine.getOptionValue(FILE_ARG);
    }

    private void parse(final String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption(createTypeArg());
        options.addOption(createFilePathArg());
        final CommandLineParser parser = new DefaultParser();
        commandLine = parser.parse(options, args);
    }

    private Option createTypeArg() {
        return Option.builder()
                .longOpt(TYPE_ARG)
                .argName(TYPE_ARG)
                .valueSeparator(VALUE_SEPARATOR)
                .hasArg()
                .required()
                .build();
    }

    private Option createFilePathArg() {
        return Option.builder()
                .longOpt(FILE_ARG)
                .argName(FILE_ARG)
                .valueSeparator(VALUE_SEPARATOR)
                .hasArg()
                .required()
                .build();
    }
}
