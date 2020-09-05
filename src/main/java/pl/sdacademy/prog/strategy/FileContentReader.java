package pl.sdacademy.prog.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileContentReader {

  public String readContent(final String path) {
    final List<String> lines = new ArrayList<>();
    try (final BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();
      while (line != null) {
        lines.add(line);
        line = br.readLine();
      }
    } catch (IOException e) { // wewnątrz plik otwarty przez br jest automatycznie zamykamy bo BufferedReader implmenetuje interfejs Closeable
      throw new StrategyException("Cannot read file " + path, e); // konwersja typu checked na wyjatek unchecked
    }
    return String.join("\n", lines);
  }
}
