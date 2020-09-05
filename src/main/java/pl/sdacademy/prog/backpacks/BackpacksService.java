package pl.sdacademy.prog.backpacks;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.sdacademy.prog.currencies.SdaException;

public class BackpacksService {

  // metoda - zbyt długa - można podzielić na 3
  public List<Backpack> splitEqually(final List<TestExecutionInfo> testExecutionInfos, final int numberOfBackpacks) {
    if (numberOfBackpacks <= 0) {
      throw new SdaException("Number of backpacks has to be positive", null); // lepiej stworzyć nowe przeciążenie
    }

    final int[] index = { 0 };
    final List<Backpack> backpacks = Stream.generate(() -> new Backpack(index[0]++))
        .limit(numberOfBackpacks)
        .collect(Collectors.toList());

    // for mozna zamienić na .forEach()
    for (final TestExecutionInfo testExecutionInfo : testExecutionInfos) {
      backpacks.stream()
          .collect(Collectors.toMap(Backpack::getIndex, Backpack::getSumOfExecutionsTimes))
          .entrySet().stream()
          .min(Comparator.comparingLong(Map.Entry::getValue))
          .ifPresent(entry -> addTestToBackpack(entry.getKey(), testExecutionInfo, backpacks));
    }
    return backpacks;
  }

  private void addTestToBackpack(final int indexToAdd,
                                 final TestExecutionInfo testExecutionInfo,
                                 final List<Backpack> backpacks) {
    backpacks.stream().filter(backpack -> backpack.getIndex() == indexToAdd)
        .findFirst().ifPresent(backpack -> backpack.addTestExecutionInfo(testExecutionInfo));
  }
}
