package pl.sdacademy.prog.streams;

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
    statisticsService
        .getCountriesWithSingleWord(dataList)
        .forEach(System.out::println);
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