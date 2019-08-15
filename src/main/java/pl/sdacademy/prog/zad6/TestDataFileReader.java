package pl.sdacademy.prog.zad6;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.prog.zad1.SdaFileNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;
import static pl.sdacademy.prog.zad6.TestDataLineValidator.NAME_INDEX;
import static pl.sdacademy.prog.zad6.TestDataLineValidator.VALUE_INDEX;

@Slf4j
public class TestDataFileReader {

    static final String SEPARATOR = ":";

    private final TestDataLineValidator testDataLineValidator;

    public TestDataFileReader(final TestDataLineValidator testDataLineValidator) {
        this.testDataLineValidator = testDataLineValidator;
    }

    public Map<String, Long> readData(final String path) {
        final Map<String, Long> data = new HashMap<>();
        try (final BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while(true) {
                final String line = reader.readLine();
                if (isNull(line)) {
                    break;
                }
                processData(line).ifPresent(entry -> data.put(entry.getKey(), entry.getValue()));
            }
        } catch (final IOException exp) {
            throw new SdaFileNotFoundException("Failed to read file", exp);
        }
        return data;
    }

    private Optional<Map.Entry<String, Long>> processData(final String line) {
        if (!testDataLineValidator.validate(line, SEPARATOR)) {
            log.warn("Detected incorrect line: ", line);
            return Optional.empty();
        }

        final String[] splitData = line.split(SEPARATOR);
        return Optional.of(Map.entry(splitData[NAME_INDEX], Long.valueOf(splitData[VALUE_INDEX])));
    }

}
