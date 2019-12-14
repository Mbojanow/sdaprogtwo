package pl.sdacademy.prog.backpacks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.sdacademy.prog.stra.GenericException;

public class TestDivider {

  public List<List<TestExecutionInfo>> divide(final List<TestExecutionInfo> testExecutionInfos,
                                              final int backpacksNum) {
    final List<List<TestExecutionInfo>> backpacks = getEmptyBackpacks(backpacksNum);

    for (final TestExecutionInfo testExecutionInfo : testExecutionInfos) {
      final List<Long> sumsOfExecutionTimes = getExecutionTimePerBackpack(backpacks);
      final int indexToAddNextElement = calculateIndexOfNextElement(sumsOfExecutionTimes);
      backpacks.get(indexToAddNextElement).add(testExecutionInfo);
    }
    return backpacks;
  }

  private List<List<TestExecutionInfo>> getEmptyBackpacks(final int backpacksNum) {
    return Stream
        .generate(() -> new ArrayList<TestExecutionInfo>())
        .limit(backpacksNum)
        .collect(Collectors.toList());
  }

  private List<Long> getExecutionTimePerBackpack(final List<List<TestExecutionInfo>> backpacks) {
    return backpacks.stream()
        .map(this::sumExecutionTime)
        .collect(Collectors.toList());
  }

  private int calculateIndexOfNextElement(final List<Long> sumsOfExecutionTimes) {
    final Optional<Long> minimumExecutionTime = sumsOfExecutionTimes
        .stream()
        .min(Comparator.naturalOrder());
    if (minimumExecutionTime.isEmpty()) {
      throw new GenericException("Could not find minimum value");
    }
    return sumsOfExecutionTimes.indexOf(minimumExecutionTime.get());
  }

  private Long sumExecutionTime(final List<TestExecutionInfo> testExecutionInfos) {
    return testExecutionInfos.stream()
        .mapToLong(TestExecutionInfo::getExecutionTime)
        .sum();
  }
}
