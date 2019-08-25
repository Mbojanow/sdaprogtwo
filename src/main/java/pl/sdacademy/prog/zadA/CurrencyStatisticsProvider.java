package pl.sdacademy.prog.zadA;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyStatisticsProvider {

  public List<String> getCountriesWithSingleWord(final List<CurrencyData> currencyData) {
//    currencyData.stream()
//        .filter(cd -> cd.getCountryName().contains(" "))
//        .map(cd -> cd.getCountryName())
//        .collect(Collectors.toList());
    return currencyData.stream()
        .map(CurrencyData::getCountryName)
        .filter(str -> !str.contains(" "))
        .collect(Collectors.toList());
  }

  public long getCountriesWithUSD(final List<CurrencyData> currencyData) {
    return currencyData.stream()
        .filter(cd -> cd.getCurrencyShortName().equals("USD"))
        .count();

//    return currencyData.stream()
//        .map(CurrencyData::getCurrencyShortName)
//        .filter(name -> name.equals("USD"))
//        .count();
  }

  public List<String> getCountriesWithEUR(final List<CurrencyData> currencyData) {
    return currencyData.stream()
        .filter(cd -> cd.getCurrencyShortName().equals("EUR"))
        .map(CurrencyData::getCountryName)
        .collect(Collectors.toList());
  }

  public List<String> getCountriesWithOwnCurrency(final List<CurrencyData> currencyData) {
    return currencyData.stream()
        .collect(Collectors.groupingBy(CurrencyData::getCurrencyShortName))
        // Map<String, Collection<CurrencyData>>
        .entrySet() // Set<Entry<String, Collection<CurrencyData>>>
        .stream()
        .filter(entry -> entry.getValue().size() == 1)
        .map(entry -> entry.getValue().get(0).getCountryName()) // Stream<String>
        .sorted()
        .collect(Collectors.toList());
  }

  public Map<String, Integer> getCurrencyToNumbersOfCountriesUsingIt(final List<CurrencyData> currencyData) {
    return currencyData.stream()
        .collect(Collectors.groupingBy(CurrencyData::getCurrencyShortName))
        .entrySet().stream()
        .map(entry -> Collections.singletonMap(entry.getKey(), entry.getValue().size())
            .entrySet().iterator().next()) // Stream obiektów Entry<String, Integer>
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public void isAllDataValid(final List<CurrencyData> currencyData) {
    currencyData.forEach(this::isDataValid);
  }

  private void isDataValid(final CurrencyData currencyData) {
    if (currencyData.getCountryName().length() < 2) {
      throw new RuntimeException("Country name is invalid");
    }

    if (currencyData.getCurrencyFullName().length() <= 2) {
      throw new RuntimeException("Currency name is invalid");
    }

    if (currencyData.getCurrencyShortName().length() != 3 ||
        !currencyData.getCurrencyShortName().equals(currencyData.getCurrencyShortName().toUpperCase())) {
      throw new RuntimeException("Currency short name is invalid");
    }
  }

  public void isAllDataValidV2(final List<CurrencyData> currencyData) {
    currencyData.stream()
        .filter(cd -> cd.getCountryName().length() < 2)
        .filter(cd -> cd.getCurrencyFullName().length() <= 2)
        .filter(cd -> cd.getCurrencyShortName().length() != 3 ||
            !cd.getCurrencyShortName().equals(cd.getCurrencyShortName().toUpperCase()))
        .findAny().ifPresent(cd -> {
      throw new RuntimeException("Some data is incorrect");
    });
  }

  public Double sumAllAmounts(final List<CurrencyData> currencyData) {
    return currencyData.stream()
        .collect(Collectors.summingDouble(cd -> cd.getAmount()));

//    currencyData.stream()
//        .map(CurrencyData::getAmount)
//        .collect(Collectors.summingDouble(d -> d));

//    currencyData.stream()
//        .map(CurrencyData::getAmount).mapToDouble(d -> d).sum();

//    currencyData.stream()
//        .collect(Collectors.summingDouble(cd -> cd.getAmount()));
  }


}
