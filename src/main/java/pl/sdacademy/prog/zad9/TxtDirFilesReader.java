package pl.sdacademy.prog.zad9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TxtDirFilesReader {

    private static final String TXT_EXTENSION = "txt";

    public List<String> readAllFilesContent(final String dir) throws IOException {
        return Files.list(Path.of(dir))
                .filter(path -> path.getFileName().toString().endsWith(TXT_EXTENSION))
                .map(this::filePathToContentAsString)
                .collect(Collectors.toList());
    }

    private String filePathToContentAsString(final Path path) {
        try {
            return Files.readString(path);
        } catch (final IOException exp) {
            throw new DetectLanguageException("Failed to read file content", exp);
        }
    }
}
