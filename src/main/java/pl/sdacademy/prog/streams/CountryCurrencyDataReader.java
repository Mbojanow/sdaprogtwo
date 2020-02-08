package pl.sdacademy.prog.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CountryCurrencyDataReader {

  private static final int EXPECTED_DATA_LEN = 3;
  private static final int COUNTRY_NAME_ELEMENT_POSITION = 0;
  private static final int CURRENCY_FULL_NAME_ELEMENT_POSITION = 1;
  private static final int CURRENCY_SHORT_NAME_ELEMENT_POSITION = 2;
  private static final int AMOUNT_ELEMENT_POSITION = 3;
  private static final int ADDITIONAL_DATA_LEN = 4;
  private static final String DATA_SEPARATOR = ",";
  private static final Double GENERATED_VALUE_UPPER_BOUND = 1e6;

  public List<CountryCurrencyData> readDataFromFile(final String path) {
    try {
      return Files.readAllLines(Paths.get(path)).stream()
          .map(line -> line.split(DATA_SEPARATOR))
          //przetwarzamy String[] -> CountryCurrencyData
          // rownoważne z elements -> toCountryCurrencyData(elements)
          .map(this::toCountryCurrencyData)
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new SdaException("Failed to read input file at " + path, e);
    }
  }

  // przetwarza String[] -> CountryCurrencyData
  // ta metoda REPREZENTUJE FUNCTION!!!!
  private CountryCurrencyData toCountryCurrencyData(final String[] elements) {
    if (elements.length < EXPECTED_DATA_LEN) {
      throw new SdaException("Incorrect data length");
    }
    final CountryCurrencyData countryCurrencyData = new CountryCurrencyData();
    countryCurrencyData.setCountry(elements[COUNTRY_NAME_ELEMENT_POSITION]);
    countryCurrencyData.setCurrencyFullName(elements[CURRENCY_FULL_NAME_ELEMENT_POSITION]);
    countryCurrencyData.setCurrencyShortName(elements[CURRENCY_SHORT_NAME_ELEMENT_POSITION]);
    countryCurrencyData.setAmount(calculateOrGenerateIfNoExist(elements));

//    if (elements.length >= ADDITIONAL_DATA_LEN) {
//      countryCurrencyData.setAmount(Double.valueOf(elements[AMOUNT_ELEMENT_POSITION]));
//    } else {
//      countryCurrencyData.setAmount(new Random().nextDouble() * 1e6);
//    }
    return countryCurrencyData;
  }

  private Double calculateOrGenerateIfNoExist(final String[] elements) {
    if (elements.length >= ADDITIONAL_DATA_LEN) {
      return Double.valueOf(elements[AMOUNT_ELEMENT_POSITION]);
    }
    return new Random().nextDouble() * GENERATED_VALUE_UPPER_BOUND;
  }

}
