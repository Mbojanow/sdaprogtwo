package pl.sdacademy.prog.stra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CountryCurrencyDataProcessingService {

  private static final int COUNTRY_INDEX = 0;
  private static final int CURRENCY_FULLNAME_INDEX = 1;
  private static final int CURRENCY_SHORTNAME_INDEX = 2;
  private static final int AMOUNT_INDEX = 3;
  private static final int MINIMUM_DATA_LEN = 3;
  private static final int ADDITIONAL_DATA_LEN = 4;
  private static final double AMOUNT_UPPER_BOUND = 10e6;

  private final CountryCurrencyDataValidator countryCurrencyDataValidator;

  // soliD - D jak DependencyInjection
  public CountryCurrencyDataProcessingService(final CountryCurrencyDataValidator countryCurrencyDataValidator) {
    this.countryCurrencyDataValidator = countryCurrencyDataValidator;
  }

  // ZŁO... WIELKIE ZŁO!!!!!
//  public CountryCurrencyDataProcessingService() {
//    countryCurrencyDataValidator = new CountryCurrencyDataValidator();
//  }

  public List<CountryCurrencyData> readDataFromFile(final String path) {
    return readLinesFromFile(path).stream()
        .filter(line -> !line.isEmpty())
        .map(line -> line.split(","))
        .map(this::toCountryCurrencyData)
        .filter(countryCurrencyDataValidator::isValid)
        .collect(Collectors.toList());
  }

  private List<String> readLinesFromFile(final String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (final IOException exp) {
      throw new GenericException("File " + path + " not found", exp);
    }
  }

  private CountryCurrencyData toCountryCurrencyData(final String[] splitLineData) {
    validateMandatoryDataExists(splitLineData);
    final String country = splitLineData[COUNTRY_INDEX];
    final String currencyFullName = splitLineData[CURRENCY_FULLNAME_INDEX];
    final String currencyShortName = splitLineData[CURRENCY_SHORTNAME_INDEX];
    final Double amount = calculateDouble(splitLineData);

    return CountryCurrencyData.builder()
        .country(country)
        .currencyFullName(currencyFullName)
        .currencyShortName(currencyShortName)
        .amount(amount)
        .build();
  }

  private void validateMandatoryDataExists(final String[] splitLineData) {
    if (splitLineData.length < MINIMUM_DATA_LEN) {
      throw new GenericException("Line does not contain all mandatory data");
    }
  }

  private Double calculateDouble(final String[] splitLineData) {
    if (splitLineData.length == ADDITIONAL_DATA_LEN) {
      return Double.parseDouble(splitLineData[AMOUNT_INDEX]);
    }
    return new Random().nextDouble() * AMOUNT_UPPER_BOUND;
  }
}
