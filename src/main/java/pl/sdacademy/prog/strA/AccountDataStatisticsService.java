package pl.sdacademy.prog.strA;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountDataStatisticsService {

    private static final int MIN_COUNTRY_LEN = 3;
    private static final int MIN_CURRENCY_LEN = 3;
    private static final int CURRENCY_SHORT_NAME = 3;

    public AccountDataStatisticsService() {
    }

    public List<String> findAllCountriesWithSingleWord(final List<AccountData> accountsData) {
        return accountsData.stream()
                .filter(accountData -> !accountData.getCountry().contains(" "))
                .map(AccountData::getCountry)
                .collect(Collectors.toList());
    }

    public List<String> findWithOwnCurrency(final List<AccountData> accountsData) {
        return accountsData.stream()
                .collect(Collectors.groupingBy(AccountData::getCurrencyShortName))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(entry -> entry.getValue().get(0).getCountry())
                .collect(Collectors.toList());
    }

    public long getNumberOfCountriesUsingCurrency(final String currency, final List<AccountData> accountsData) {
        return toAccountDataStreamWithCurrency(currency, accountsData)
                .count();
    }

    public List<String> getCountriesWithCurrency(final String currency, final List<AccountData> accountsData) {
        return toAccountDataStreamWithCurrency(currency, accountsData)
                .map(AccountData::getCountry)
                .collect(Collectors.toList());
    }

    private Stream<AccountData> toAccountDataStreamWithCurrency(final String currency, final List<AccountData> accountsData) {
        return accountsData.stream()
                .filter(accountData -> accountData.getCurrencyShortName().equals(currency));
    }

    public Map<String, Integer> getCurrencyToCountriesNum(final List<AccountData> accountsData) {
        return accountsData.stream()
                .collect(Collectors.groupingBy(AccountData::getCurrencyShortName))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    public Double sumAmmounts(final List<AccountData> accountsData) {
        return accountsData.stream()
                .mapToDouble(AccountData::getAmount).sum();
    }

    public boolean countryWithNameLongerThan(final int charNum, final List<AccountData> accountsData) {
        return accountsData.stream()
                .map(AccountData::getCountry)
                .anyMatch(country -> country.length() >= charNum);
    }

    public boolean isAllDataCorrect(final List<AccountData> accountsData) {
        return accountsData.stream()
                .anyMatch(this::isDataCorrect);
    }

    private boolean isDataCorrect(final AccountData accountData) {
        final String currencyShortName = accountData.getCurrencyShortName();
        return accountData.getCountry().length() >= MIN_COUNTRY_LEN &&
                accountData.getCurrencyFullName().length() >= MIN_CURRENCY_LEN &&
                accountData.getCurrencyShortName().length() == CURRENCY_SHORT_NAME &&
                currencyShortName.equals(currencyShortName.toLowerCase());


    }
}
