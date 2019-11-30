package pl.sdacademy.prog.stra;

public class StreamsMain {

  public static void main(String[] args) {
    final String pathToLoad = args[0];
    final CountryCurrencyDataProcessingService service = new CountryCurrencyDataProcessingService();
    service.readDataFromFile(pathToLoad)
        .forEach(System.out::println);

    final String pathToSave = args[1];
    final CountryCurrencyDataCsvFileService savingService = new CountryCurrencyDataCsvFileService();
    savingService.saveDataToCsvFile(pathToSave, service.readDataFromFile(pathToLoad));
  }
}
