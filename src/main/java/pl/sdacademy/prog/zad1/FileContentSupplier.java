package pl.sdacademy.prog.zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class FileContentSupplier {

    public String getContentAsString(final String path) {
        final List<String> lines = new ArrayList<>();
        try (final BufferedReader reader = new BufferedReader(new FileReader(path))){
            while (true) {
                final String line = reader.readLine();
                if (nonNull(line)) {
                    lines.add(line);
                } else {
                    break;
                }
            }
        } catch (final IOException exp) {
            throw new SdaFileNotFoundException("Input file could not be found", exp);
        }

        return String.join("\n", lines);
    }
}
