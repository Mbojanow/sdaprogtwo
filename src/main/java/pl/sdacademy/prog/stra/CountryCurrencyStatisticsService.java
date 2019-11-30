package pl.sdacademy.prog.stra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryCurrencyStatisticsService {

  public Collection<String> findCountriesNamesWithSingleWord(final Collection<CountryCurrencyData> data) {
    return data.stream()
        .map(CountryCurrencyData::getCountry)
        .filter(countryName -> !countryName.contains(" "))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public long findAllCountriesWithUSDCurrency(final Collection<CountryCurrencyData> data) {
    final Map<String, List<CountryCurrencyData>> currencyToCountryCurrencyData =
        data.stream()
            .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName));

    return currencyToCountryCurrencyData.entrySet().stream()
        .filter(entry -> entry.getKey().equals("USD"))
        .map(Map.Entry::getValue)
        .flatMap(Collection::stream)
        .count();
  }

  public List<String> findCountriesNameWithEURCurrency(final Collection<CountryCurrencyData> data) {
    return data.stream()
        .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName))
        .getOrDefault("EUR", Collections.emptyList())
        .stream()
        .map(CountryCurrencyData::getCountry)
        .collect(Collectors.toList());
  }

  public List<String> findCountriesWithOwnCurrency(final Collection<CountryCurrencyData> data) {
    return data.stream()
        .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName))
        .values().stream()
        .filter(list -> list.size() == 1)
        .flatMap(Collection::stream) //alternatywa: map(list -> list.get(0)
        .map(CountryCurrencyData::getCountry)
        .collect(Collectors.toList());
  }

  public Map<String, Integer> getCurrenciesUsageStatistics(final Collection<CountryCurrencyData> data) {
    return data.stream()
        .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName))
        .entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
  }

  public Double getAmountSum(final Collection<CountryCurrencyData> data) {
    return data.stream()
        .mapToDouble(CountryCurrencyData::getAmount)
        .sum();

//    return data.stream()
//        .map(CountryCurrencyData::getAmount)
//        .collect(Collectors.summingDouble(x -> x));

//    return data.stream()
//        .collect(Collectors.summingDouble(ccd -> ccd.getAmount()));
  }
}
