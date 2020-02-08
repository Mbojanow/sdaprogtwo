package pl.sdacademy.prog.streams;

import java.util.List;

public class StreamsMain {
  public static void main(String[] args) {
    final String path = args[0];
    final CountryCurrencyDataReader dataReader = new CountryCurrencyDataReader();
    final List<CountryCurrencyData> dataList = dataReader.readDataFromFile(path);
    dataList.forEach(countryCurrencyData ->
        System.out.println(countryCurrencyData.getCountry() + " " +
            countryCurrencyData.getCurrencyFullName() + " " +
            countryCurrencyData.getCurrencyShortName() + " " +
            countryCurrencyData.getAmount()));

    final String outputPath = args[1];
    final CountryCurrencyDataWriter dataWriter = new CountryCurrencyDataWriter();
    dataWriter.saveDataToFile(outputPath, dataList);
  }
}
