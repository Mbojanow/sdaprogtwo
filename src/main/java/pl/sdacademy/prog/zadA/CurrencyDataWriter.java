package pl.sdacademy.prog.zadA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyDataWriter {

  public void saveToFile(final String path, final Collection<CurrencyData> currencyData) throws IOException {
    final List<String> outputList = currencyData.stream()
        .map(cd -> mapToCSV(cd))
        .collect(Collectors.toList());
    Files.write(Paths.get(path), outputList, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
  }

  private String mapToCSV(final CurrencyData currencyData) {
    return Stream.of(currencyData.getCountryName(), currencyData.getCurrencyFullName(),
        currencyData.getCurrencyShortName(), currencyData.getAmount().toString())
        .collect(Collectors.joining(","));


    //Collectors.joining(".");
//    final StringBuilder stringBuilder = new StringBuilder();
//    return stringBuilder.append(currencyData.getCountryName())
//        .append(",")
//        .append(currencyData.getCurrencyFullName())
//        .append(",")
//        .append(currencyData.getCurrencyShortName())
//        .append(",")
//        .append(currencyData.getAmount())
//        .toString();
  }
}
