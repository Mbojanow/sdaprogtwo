package pl.sdacademy.prog.currencies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CurrencyDataReader {

  private static final int MINIMUM_ELEMENTS_NUM = 3;
  private static final int COUNTRY_INDEX = 0;
  private static final int CURRENCY_NAME_INDEX = 1;
  private static final int CURRENCY_SYMBOL_INDEX = 2;
  private static final int AMOUNT_INDEX = 3;
  private static final int ADDITIONAL_DATA_LENGTH = 4;
  private static final String SPLITERATOR = ",";
  private static final Double AMOUNT_UPPER_BOUND = 1e6;

  public List<CurrencyData> readFromFile(final String path) {
    try {
//      final BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//      String line = bufferedReader.readLine();
//      while (line != null) {
//        // zrób coś z line
//      }
      return Files.readAllLines(Paths.get(path)).stream()
          .map(this::splitLine)
          .filter(this::isLineValid)
          .map(this::toCurrencyData)
          .collect(Collectors.toList());
    } catch (IOException e) { // przetwarzac wyjątek checked na unchecked
      throw new SdaException("Cannot read file in " + path, e);
    }
  }

  private String[] splitLine(final String line) {
    return line.split(SPLITERATOR);
  }

  private boolean isLineValid(final String[] splitLine) {
     if (splitLine.length < MINIMUM_ELEMENTS_NUM) {
       return false;
     }

     // można usprawnić -> nazwanie stałych: 2, 2, 3
     return splitLine[COUNTRY_INDEX].length() >= 2 && splitLine[CURRENCY_NAME_INDEX].length() > 2
         && splitLine[CURRENCY_SYMBOL_INDEX].length() == 3 &&
         splitLine[CURRENCY_SYMBOL_INDEX].toUpperCase().equals(splitLine[CURRENCY_SYMBOL_INDEX]) &&
         splitLine[CURRENCY_SYMBOL_INDEX].chars().allMatch(Character::isLetter);
  }

  private CurrencyData toCurrencyData(final String[] splitLine) {
    final String country = splitLine[COUNTRY_INDEX];
    final String currencyName = splitLine[CURRENCY_NAME_INDEX];
    final String currencySymbol = splitLine[CURRENCY_SYMBOL_INDEX];
    Double amount;
    if (splitLine.length == ADDITIONAL_DATA_LENGTH) {
      amount = Double.parseDouble(splitLine[AMOUNT_INDEX]);
    } else {
      amount = Math.abs(new Random().nextDouble()) * AMOUNT_UPPER_BOUND;
    }
    return new CurrencyData(country, currencyName, currencySymbol, amount); // alternatywa - uzycie buildera
  }

}
