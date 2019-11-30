package pl.sdacademy.prog.stra;

public class StreamsMain {

  public static void main(String[] args) {
    final String pathToLoad = args[0];
    final CountryCurrencyDataValidator validator
        = new CountryCurrencyDataValidator();
    final CountryCurrencyDataProcessingService service
        = new CountryCurrencyDataProcessingService(validator);
    service.readDataFromFile(pathToLoad)
        .forEach(System.out::println);

//    final String pathToSave = args[1];
//    final CountryCurrencyDataCsvFileService savingService = new CountryCurrencyDataCsvFileService();
//    savingService.saveDataToCsvFile(pathToSave, service.readDataFromFile(pathToLoad));

    final CountryCurrencyStatisticsService statisticsService = new CountryCurrencyStatisticsService();
    statisticsService.getCurrenciesUsageStatistics(service.readDataFromFile(pathToLoad))
      .forEach((key, value) -> System.out.println(key + " " + value));
  }
}
