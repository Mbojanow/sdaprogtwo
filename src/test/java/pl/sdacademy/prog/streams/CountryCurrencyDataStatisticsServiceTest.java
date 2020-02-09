package pl.sdacademy.prog.streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountryCurrencyDataStatisticsServiceTest {

  private CountryCurrencyDataReader dataReader = new CountryCurrencyDataReader();
  private CountryCurrencyDataStatisticsService statisticsService = new CountryCurrencyDataStatisticsService();
  private List<CountryCurrencyData> dataList;

  @BeforeEach
  void setUp() {
    dataList = dataReader.readDataFromFile(
        "/Users/michalbojanowski/work/sdaprogtwo/src/main/resources/streamsData");
  }

  @Test
  void testA() {
    final List<String> singleWordCountries = statisticsService
        .getCountriesWithSingleWord(dataList);

    singleWordCountries
        .forEach(countryName -> assertThat(countryName).doesNotContainAnyWhitespaces());
  }

  @Test
  void testB() {
    final long count = statisticsService.getNumberOfCountriesWithUSDCurrency(dataList);
    System.out.println(count);
  }

  @Test
  void testC() {
    statisticsService.getCountriesWithEURCurrency(dataList).forEach(System.out::println);
  }

  @Test
  void testD() {
    statisticsService.getCountriesWithOwnCurrency(dataList).forEach(System.out::println);
  }

  @Test
  void testE() {
    statisticsService.getCurrencyUsageStatistics(dataList)
        .forEach((currency, count) ->
            System.out.println(currency + " is used in " + count + " countries"));
  }

}