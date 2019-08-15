package pl.sdacademy.prog.zad6;

import org.apache.commons.cli.*;

public class BackpackArgumentsParser {
    private static final String NUM_BACKPACK_ARG = "b";
    private static final String SOURCE_FILE_ARG = "s";
    private static final String TARGET_DIR_ARG = "o";
    private static final char VALUE_SEPARATOR = '=';

    private CommandLine commandLine;

    public BackpackArgumentsParser(final String[] args) throws ParseException {
        parse(args);
    }

    public int getBackpackNum() {
        return Integer.valueOf(commandLine.getOptionValue(NUM_BACKPACK_ARG));
    }

    public String getSourceFile() {
        return commandLine.getOptionValue(SOURCE_FILE_ARG);
    }

    public String getTargetDir() {
        return commandLine.getOptionValue(TARGET_DIR_ARG);
    }

    private void parse(final String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption(createBackpackNumArg());
        options.addOption(createSourceFileSourceArg());
        options.addOption(createTargetDirArg());
        final CommandLineParser parser = new DefaultParser();
        commandLine = parser.parse(options, args);
    }

    private Option createBackpackNumArg() {
        return createRequiredArg(NUM_BACKPACK_ARG);
    }

    private Option createSourceFileSourceArg() {
        return createRequiredArg(SOURCE_FILE_ARG);
    }

    private Option createTargetDirArg() {
        return createRequiredArg(TARGET_DIR_ARG);
    }

    private Option createRequiredArg(final String name) {
        return Option.builder()
                .longOpt(name)
                .argName(name)
                .valueSeparator(VALUE_SEPARATOR)
                .hasArg()
                .required()
                .build();
    }
}
