package pl.sdacademy.prog.backpacks;

import java.util.List;

// Dodać pasowanie lini komend
// Dodać fasade która wykonuje cały proces (czytanie, przetworzenie plecaków, zapis do plików)
// Dodać testy na poszczególne klasy

public class BackpacksMain {
  // /Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources/tests
  // 4
  // /Users/michalbojanowski/work/spam/SDA/sdaprogtwo_zdpol17/src/main/resources

  public static void main(String[] args) {
    String source = args[0];
    Integer backpacksNum = Integer.parseInt(args[1]);
    String outputDir = args[2];
    final TestExecutionInfoReader reader = new TestExecutionInfoReader();
    final BackpacksService backpacksService = new BackpacksService();
    final BackpacksDataWriter writer = new BackpacksDataWriter();

    final List<TestExecutionInfo> testExecutionInfos = reader.readFromFile(source);
    final List<Backpack> backpacks = backpacksService.splitEqually(testExecutionInfos, backpacksNum);
    writer.saveToFiles(backpacks, outputDir);
  }
}
