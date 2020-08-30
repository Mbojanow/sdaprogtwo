package pl.sdacademy.prog.currencies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyDataReader {

  public List<CurrencyData> readFromFile(final String path) {
    // 1. sprawdzic czy linika jest poprawna -> zignorujemy niepoprawne linie | STREAM -> filter
    // 2. przetworzenie linijki na obiekt javowy                              | STREAM -> map
    // 3. zebranie wszystkiego do listy                                       | STREAM -> collect
    try {
      return Files.readAllLines(Paths.get(path)).stream()
          .filter(line -> {
            final String[] splitLine = line.split(",");
            return splitLine.length >= 3;
          })
          .map(line -> {
            final String[] splitLine = line.split(",");
            final String country = splitLine[0];
            final String currencyName = splitLine[1];
            final String currencySymbol = splitLine[2];
            Double amount = null;
            if (splitLine.length == 4) {
              amount = Double.parseDouble(splitLine[3]);
            }
            return new CurrencyData(country, currencyName, currencySymbol, amount); // alternatywa - uzycie buildera
          })
          .collect(Collectors.toList());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
