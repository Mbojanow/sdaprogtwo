package pl.sdacademy.prog.streams;

import static java.util.Objects.nonNull;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryCurrencyDataWriter {

  public void saveDataToFile(final String outputPath, final List<CountryCurrencyData> dataList) {
    final List<String> lines = dataList.stream()
        //countryCurrencyData -> toCSVLine(countryCurrencyData)
        .map(this::toCSVLine)
        .collect(Collectors.toList());

    try {
      Files.write(Paths.get(outputPath), lines, StandardOpenOption.CREATE);
    } catch (IOException e) {
      throw new SdaException("Cannot write data to file " + outputPath, e);
    }
  }

  private String toCSVLine(final CountryCurrencyData countryCurrencyData) {
    return Stream.of(countryCurrencyData.getCountry(),
        countryCurrencyData.getCurrencyFullName(),
        countryCurrencyData.getCurrencyShortName(),
        countryCurrencyData.getAmount())
        //elem -> nonNull(elem)
        .filter(Objects::nonNull)
        //elem -> elem.toString()
        .map(Object::toString)
        .collect(Collectors.joining(","));
  }
}
