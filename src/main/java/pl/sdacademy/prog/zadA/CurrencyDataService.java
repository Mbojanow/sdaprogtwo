package pl.sdacademy.prog.zadA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CurrencyDataService {

  private static final int MIN_DATA_LEN = 3;
  private static final int ADDITIONAL_DATA_LEN = 4;
  private static final double GENERATED_AMOUNT_UPPER_BOUND = 1e6;
  private static final int COUNTRY_INDEX = 0;
  private static final int CURRENCY_SHORT_NAME_INDEX = 1;
  private static final int CURRENCY_FULL_NAME_INDEX = 2;
  private static final int AMOUNT_INDEX = 3;

  public List<CurrencyData> processDataFromFile(final String filePath) throws IOException {
    return Files.readAllLines(Paths.get(filePath))
        .stream()
        .map(this::mapToCurrencyData)
        .collect(Collectors.toList());
  }

  // Optional<CurrencyData>
  private CurrencyData mapToCurrencyData(final String fileLine) {
    final String[] splitLine = fileLine.split(",");
    if (splitLine.length < MIN_DATA_LEN) {
      throw new RuntimeException("Data length is not long enough");
    }

    Double amount;
    if (splitLine.length == ADDITIONAL_DATA_LEN) {
      amount = Double.valueOf(splitLine[AMOUNT_INDEX]);
    } else {
      amount = new Random().nextDouble() * GENERATED_AMOUNT_UPPER_BOUND;
    }
    // 2e5 = 2 * 10 ^ 5
    // 1e6 = 1 * 10 ^ 6

    return CurrencyData.builder()
        .countryName(splitLine[COUNTRY_INDEX])
        .currencyFullName(splitLine[CURRENCY_SHORT_NAME_INDEX])
        .currencyShortName(splitLine[CURRENCY_FULL_NAME_INDEX])
        .amount(amount)
        .build();
  }
}
