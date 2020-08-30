package pl.sdacademy.prog.currencies;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyDataStatisticsProcessor {

  // pobrać nazwy wszystkich państw, których nazwa jest jednym wyrazem
  public List<String> findCountriesWithSingleWord(final List<CurrencyData> data) {
    return data.stream()
        .map(CurrencyData::getCountry)
        .filter(countryName -> !countryName.contains(" "))
        .collect(Collectors.toList());
  }

  // ilość państw w ktorych używana jest waluta USD
  public long findCurrenciesThatUseUSD(final List<CurrencyData> data) {
    return data.stream()
        .map(CurrencyData::getCurrencySymbol)
        .filter(symbol -> symbol.equals("USD"))
        .count();
  }

  public List<String> findCountriesUsingEUR(final List<CurrencyData> data) {
    return data.stream()
        .filter(currencyData -> currencyData.getCurrencySymbol().equals("EUR"))
        .map(CurrencyData::getCountry)
        .collect(Collectors.toList());
  }

  public List<String> findCountriesWithOwnCurrency(final List<CurrencyData> data) {
    return data.stream()
        .collect(Collectors.groupingBy(CurrencyData::getCurrencySymbol))
        .values().stream()
        .filter(elem -> elem.size() == 1)
        .map(elem -> elem.get(0).getCountry())
        .collect(Collectors.toList());
  }

  public Map<String, Integer> findNumberOfCountriesPerCurrencyType(final List<CurrencyData> data) {
    return data.stream()
        .collect(Collectors.groupingBy(CurrencyData::getCurrencySymbol))
        .entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
  }

  public double sumAmounts(List<CurrencyData> data) {
    return data.stream()
        .mapToDouble(CurrencyData::getAmount)
        .sum();
  }


}
