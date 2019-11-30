package pl.sdacademy.prog.stra;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CountryCurrencyService {

  public Collection<String> findCountriesNamesWithSingleWord(final Collection<CountryCurrencyData> data) {
    return data.stream()
        .map(CountryCurrencyData::getCountry)
        .filter(countryName -> !countryName.contains(" "))
        .collect(Collectors.toList());
  }

}
