package pl.sdacademy.prog.zad6;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class BackpackProcessingFacade {

    private final TestDataFileReader testDataFileReader;
    private final TestDataProcessingService testDataProcessingService;
    private final BackpackDataFileWriter backpackDataFileWriter;

    public BackpackProcessingFacade(final TestDataFileReader testDataFileReader, final TestDataProcessingService testDataProcessingService, final BackpackDataFileWriter backpackDataFileWriter) {
        this.testDataFileReader = testDataFileReader;
        this.testDataProcessingService = testDataProcessingService;
        this.backpackDataFileWriter = backpackDataFileWriter;
    }

    public void process(final int backpackNum, final String sourceFile, final String outputDir) {
        final Map<String, Long> output = testDataFileReader.readData(sourceFile);
        final List<Map<String, Long>> data = testDataProcessingService.process(backpackNum, output);
        final LocalDateTime date = LocalDateTime.now();
        for (int idx = 0; idx < data.size(); idx++) {
            printBackpack(idx, data.get(idx));
            backpackDataFileWriter.save(idx, date, outputDir, data.get(idx));
        }
    }

    private static void printBackpack(final int index, final Map<String, Long> backpackData) {
        System.out.println("Data for backpack " + index);
        backpackData.forEach((testName, execTime) -> System.out.println(testName + " " + execTime));
    }
}
