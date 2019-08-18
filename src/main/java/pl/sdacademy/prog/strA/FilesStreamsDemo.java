package pl.sdacademy.prog.strA;

import java.io.IOException;

public class FilesStreamsDemo {

    public static void main(String[] args) throws IOException {
        final String path = args[0];

        final AccountDataService accountDataService = new AccountDataService();

        // accountDataService.readFromFile(path).forEach(System.out::println);

        //accountDataService.saveToFile("E:\\dev\\SDA\\Prog2\\streamsData2.txt", accountDataService.readFromFile(path));

        final AccountDataStatisticsService accountDataStatisticsService = new AccountDataStatisticsService();

//        accountDataStatisticsService.findWithOwnCurrency(accountDataService.readFromFile(path))
//                .forEach(System.out::println);
//
//        accountDataStatisticsService.findAllCountriesWithSingleWord(accountDataService.readFromFile(path))
//                .forEach(System.out::println);
//        final long usdCount = accountDataStatisticsService.getNumberOfCountriesUsingCurrency("USD", accountDataService.readFromFile(path));
//        System.out.println(usdCount);

//        accountDataStatisticsService.getCountriesWithCurrency("EUR", accountDataService.readFromFile(path))
//        .forEach(System.out::println);

        accountDataStatisticsService.getCurrencyToCountriesNum(accountDataService.readFromFile(path)).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
