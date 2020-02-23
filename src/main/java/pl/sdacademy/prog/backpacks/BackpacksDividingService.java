package pl.sdacademy.prog.backpacks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pl.sdacademy.prog.streams.SdaException;

public class BackpacksDividingService {

  public List<BackpackTests> divideIntoBackpacks(final List<TestExecutionInfo> allTests,
                                                 final int backpacksNum) {
    validateBackpackNum(backpacksNum);
    final List<BackpackTests> backpacks = initializeEmptyBackpacks(backpacksNum);
    allTests.forEach(testExecutionInfo -> processTestExecutionInfo(testExecutionInfo, backpacks));
    return backpacks;
  }

  private void validateBackpackNum(final int backpacksNum) {
    if (backpacksNum <= 0) {
      throw new SdaException("Backpacks number has to be positive");
    }
  }

  private List<BackpackTests> initializeEmptyBackpacks(final int backpacksNum) {
    final List<BackpackTests> backpacks = new ArrayList<>();
    for (int idx = 0; idx < backpacksNum; idx++) {
      backpacks.add(new BackpackTests());
    }
    return backpacks;
  }

  private void processTestExecutionInfo(final TestExecutionInfo testExecutionInfo,
                                        final List<BackpackTests> backpacks) {
    final int backpackIndex = findBackpackIndexWithLowestExecutionTime(backpacks);
    backpacks.get(backpackIndex).addTestInfo(testExecutionInfo);
  }

  private int findBackpackIndexWithLowestExecutionTime(final List<BackpackTests> backpacks) {
    final int index[] = {0};
    return backpacks.stream()
        .collect(Collectors.toMap(backpack -> index[0]++,
            BackpackTests::sumExecutionTimes))
        .entrySet().stream()
        .min(Comparator.comparingLong(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .orElseThrow(() -> new SdaException("This should not happen"));
  }

}
