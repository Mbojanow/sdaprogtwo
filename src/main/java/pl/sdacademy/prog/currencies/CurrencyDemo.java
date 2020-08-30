package pl.sdacademy.prog.currencies;

import java.util.List;

public class CurrencyDemo {
  public static void main(String[] args) {
    //"/Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources/streamsData.txt" "/Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources/streamsData2.txt"

    // "C:/Program Files"

    final String path = args[0];
    final CurrencyDataReader currencyDataReader = new CurrencyDataReader();
    final List<CurrencyData> readData = currencyDataReader.readFromFile(path);

    final CurrencyDataWriter currencyDataWriter = new CurrencyDataWriter();
    final String savePath = args[1];
    currencyDataWriter.saveToFile(savePath, readData);
  }
}
