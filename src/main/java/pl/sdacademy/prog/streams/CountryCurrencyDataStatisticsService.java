package pl.sdacademy.prog.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryCurrencyDataStatisticsService {

  public List<String> getCountriesWithSingleWord(final List<CountryCurrencyData> dataList) {
    return dataList.stream()
        .filter(countryCurrencyData -> !countryCurrencyData.getCountry().contains(" "))
        .map(CountryCurrencyData::getCountry)
        .collect(Collectors.toList());
  }

  public long getNumberOfCountriesWithUSDCurrency(final List<CountryCurrencyData> dataList) {
    return filterCountryCurrencyDataByCurrencyShortName("USD", dataList)
        .map(CountryCurrencyData::getCurrencyShortName)
        .count();
    //.collect(Collectors.toList()).size(); // OK ale można lepiej
  }

  public List<String> getCountriesWithEURCurrency(final List<CountryCurrencyData> dataList) {
    return filterCountryCurrencyDataByCurrencyShortName("EUR", dataList)
        .map(CountryCurrencyData::getCountry)
        .collect(Collectors.toList());
  }

  private Stream<CountryCurrencyData> filterCountryCurrencyDataByCurrencyShortName(
      final String currencyShortName, final List<CountryCurrencyData> dataList) {
    return dataList.stream()
        .filter(countryCurrencyData -> countryCurrencyData.getCurrencyShortName()
            .equals(currencyShortName));
  }

  public List<String> getCountriesWithOwnCurrency(final List<CountryCurrencyData> dataList) {
    return dataList.stream()
        .collect(Collectors
            //countryCurrencyData -> countryCurrencyData.getCurrencyShortName()
            .groupingBy(CountryCurrencyData::getCurrencyShortName))
        .values().stream()
        .filter(countryDataWithSameCurrency -> countryDataWithSameCurrency.size() == 1)
        //lista jednoelementowa -> nazwa panstwa tego pojedynczego elementu
        .map(countryCurrencyDataList -> countryCurrencyDataList.get(0).getCountry())
        .collect(Collectors.toList());
  }

  public Map<String, Integer> getCurrencyUsageStatistics(final List<CountryCurrencyData> dataList) {
    return dataList.stream()
        .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName))
        .entrySet().stream()
        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().size()));
  }

  public Double sumAllAmounts(final List<CountryCurrencyData> dataList) {
    //1 sposób
//    dataList.stream()
//        .collect(Collectors
//            .summingDouble(countryCurrencyData -> countryCurrencyData.getAmount()));

    //sposób2
//    dataList.stream()
//        .map(CountryCurrencyData::getAmount)
//        .collect(Collectors
//            .summingDouble(amount -> amount));

    return dataList.stream()
        // to jest DoubleStream, nie zwykły Stream!!!
        .mapToDouble(CountryCurrencyData::getAmount)
        .sum();
  }

  public List<String> getCountriesWithNameMoreThan30Chars(final List<CountryCurrencyData> dataList) {
    return dataList.stream()
        .map(CountryCurrencyData::getCountry)
        .filter(country -> country.length() > 30)
        .collect(Collectors.toList());
  }
}
