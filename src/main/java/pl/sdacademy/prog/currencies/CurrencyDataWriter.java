package pl.sdacademy.prog.currencies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyDataWriter {

  private static final String OUTPUT_SPLIT_CHAR = ",";

  public void saveToFile(final String path, final List<CurrencyData> data) {
    final List<String> lines = data.stream()
        .map(this::toLine)
        .collect(Collectors.toList());
    try {
      Files.write(Paths.get(path), lines, StandardOpenOption.CREATE);
    } catch (IOException e) {
      throw new SdaException("Cannot write data to file", e);
    }
  }

  private String toLine(final CurrencyData currencyData) {
    return Stream.of(currencyData.getCountry(), currencyData.getCurrencyName(), currencyData.getCurrencySymbol(), currencyData.getAmount())
        .filter(Objects::nonNull)
        .map(Object::toString)
        .collect(Collectors.joining(OUTPUT_SPLIT_CHAR));
  }
}
