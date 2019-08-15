package pl.sdacademy.prog.zad6;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class BackpackDemo {

    public static void main(String[] args) {

        final TestDataLineValidator testDataLineValidator = new TestDataLineValidator();
        final TestDataFileReader testDataFileReader = new TestDataFileReader(testDataLineValidator);
        final Map<String, Long> output = testDataFileReader.readData(args[1]);

        final TestDataProcessingService testDataProcessingService = new TestDataProcessingService();
        final List<Map<String, Long>> data = testDataProcessingService.process(Integer.valueOf(args[0]), output);
        final BackpackDataFileWriter writer = new BackpackDataFileWriter();

        final LocalDateTime date = LocalDateTime.now();
        for (int idx = 0; idx < data.size(); idx++) {
            printBackpack(idx, data.get(idx));
            writer.save(idx, date, args[2], data.get(idx));
        }
    }

    private static void printBackpack(final int index, final Map<String, Long> backpackData) {
        System.out.println("Data for backpack " + index);
        backpackData.forEach((x, y) -> System.out.println(x + " " + y));
    }
}
