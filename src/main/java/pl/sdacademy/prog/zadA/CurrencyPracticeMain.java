package pl.sdacademy.prog.zadA;

import java.io.IOException;
import java.util.List;

public class CurrencyPracticeMain {

  public static void main(String[] args) throws IOException {
    final String inputFile = args[0];
    final String outputFile = args[1];

    final CurrencyDataService currencyDataService = new CurrencyDataService();

    final List<CurrencyData> currencyData = currencyDataService.processDataFromFile(inputFile);
    final CurrencyDataWriter currencyDataWriter = new CurrencyDataWriter();
    currencyDataWriter.saveToFile(outputFile, currencyData);
  }
}
