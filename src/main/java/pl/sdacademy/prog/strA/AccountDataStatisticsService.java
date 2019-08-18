package pl.sdacademy.prog.strA;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountDataStatisticsService {

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
}
