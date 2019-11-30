package pl.sdacademy.prog.stra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CountryCurrencyDataCsvFileService {

  public void saveDataToCsvFile(final String path, final Collection<CountryCurrencyData> data) {
    final List<String> csvLines = data.stream()
        .map(this::toCsvLine)
        .collect(Collectors.toList());
    saveDataToCsvFile(path, csvLines);
  }

  private String toCsvLine(final CountryCurrencyData data) {
    return String.join(",", data.getCountry(), data.getCurrencyFullName(),
        data.getCurrencyShortName(), data.getAmount().toString());
//    Stream.of(data.getCountry(), data.getCurrencyFullName(),
//        data.getCurrencyShortName(), data.getAmount().toString())
//        .collect(Collectors.joining(","));
  }

  private void saveDataToCsvFile(final String path, final List<String> csvLines) {
    try {
      Files.write(Paths.get(path), csvLines, StandardOpenOption.CREATE);
    } catch (final IOException exp) {
      throw new GenericException("Cannot save file to " + path, exp);
    }
  }
}
