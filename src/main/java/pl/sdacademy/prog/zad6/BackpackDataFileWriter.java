package pl.sdacademy.prog.zad6;

import pl.sdacademy.prog.zad1.SdaFileNotFoundException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static pl.sdacademy.prog.zad6.TestDataFileReader.SEPARATOR;

public class BackpackDataFileWriter {

    private static final String FILE_PATH_TEMPLATE = "%s/backpack_%d_%s.txt";

    public void save(final int index, final LocalDateTime date, final String saveDir, final Map<String, Long> data) {
        final String fileName = String.format(FILE_PATH_TEMPLATE, saveDir, index, date.format(DateTimeFormatter.BASIC_ISO_DATE));

        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            data.forEach((testName, testExecTime) -> writeTestDataLineToFile(testName, testExecTime, writer));
        } catch (final IOException exp) {
            throw new SdaFileNotFoundException("Cannot write to file", exp);
        }
    }

    private void writeTestDataLineToFile(final String testName, final Long executionTime, final BufferedWriter writer) {
        try {
            writer.write(testName + SEPARATOR + executionTime);
            writer.newLine();
        } catch (final IOException exp) {
            throw new SdaFileNotFoundException("Cannot write line to file", exp);
        }
    }
}
