package pl.sdacademy.prog.stra;

public class CountryCurrencyDataValidator {

  private static final int COUNTRY_NAME_MIN_LEN = 2;
  private static final int CURRENCY_FULL_NAME_MIN_LEN = 3;
  private static final int CURRENCY_SHORT_NAME_LEN = 3;

  public boolean isValid(final CountryCurrencyData countryCurrencyData) {
    return isCountryNameValid(countryCurrencyData) &&
        isCurrencyFullNameValid(countryCurrencyData) &&
        isCurrencyShortNameValid(countryCurrencyData);
  }

  private boolean isCountryNameValid(final CountryCurrencyData data) {
    return data.getCountry().length() >= COUNTRY_NAME_MIN_LEN;
  }

  private boolean isCurrencyFullNameValid(final CountryCurrencyData data) {
    return data.getCurrencyFullName().length() >= CURRENCY_FULL_NAME_MIN_LEN;
  }

  private boolean isCurrencyShortNameValid(final CountryCurrencyData data) {
    return data.getCurrencyShortName()
        .matches("[A-Z]{"+ CURRENCY_SHORT_NAME_LEN + "}");
    // &&
//        data.getCurrencyShortName().length() == CURRENCY_SHORT_NAME_LEN &&
//        data.getCurrencyShortName().toUpperCase().equals(data.getCurrencyShortName());
  }
}
