package pl.sdacademy.prog.zad6;

import org.apache.commons.cli.ParseException;

public class BackpackDemo {

    public static void main(String[] args) throws ParseException {
        final TestDataLineValidator testDataLineValidator = new TestDataLineValidator();
        final TestDataFileReader testDataFileReader = new TestDataFileReader(testDataLineValidator);
        final TestDataProcessingService testDataProcessingService = new TestDataProcessingService();
        final BackpackDataFileWriter backpackDataFileWriter = new BackpackDataFileWriter();
        final BackpackProcessingFacade backpackProcessingFacade = new BackpackProcessingFacade(testDataFileReader, testDataProcessingService, backpackDataFileWriter);
        final BackpackArgumentsParser argumentsParser = new BackpackArgumentsParser(args);

        backpackProcessingFacade.process(argumentsParser.getBackpackNum(), argumentsParser.getSourceFile(), argumentsParser.getTargetDir());
    }
}
