package pl.sdacademy.prog.zadA;

import java.io.IOException;

public class CurrencyPracticeMain {

  public static void main(String[] args) throws IOException {
    final String filePath = args[0];

    final CurrencyDataService currencyDataService = new CurrencyDataService();

    currencyDataService.processDataFromFile(filePath)
        .forEach(currencyData -> System.out.println(currencyData));
  }
}
