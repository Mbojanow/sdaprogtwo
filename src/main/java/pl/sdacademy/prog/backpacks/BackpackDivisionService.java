package pl.sdacademy.prog.backpacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BackpackDivisionService {

  public Map<Integer, List<TestExecutionInfo>> divideEvenly(final List<TestExecutionInfo> executionInfos,
                                                            final int backpackNum) {
    final Map<Integer, List<TestExecutionInfo>> dividedBackpacks = new HashMap<>();

    for (int idx = 0; idx < backpackNum; idx++) {
      //final List<Object> objects = Collections.emptyList();
      //objects.add(new Object());
      // EXCEPTION bo kolekckje z Collections są IMMUTABLE
      dividedBackpacks.put(idx, new ArrayList<>());
    }

    for (final TestExecutionInfo testExecutionInfo : executionInfos) {
      final Map<Integer, Long> backpackIndexToSumExecutionTime = dividedBackpacks.entrySet().stream()
          .collect(Collectors.toMap(Map.Entry::getKey, entrye -> (Long) entrye.getValue()
              .stream()
              .map(TestExecutionInfo::getExecutionTime).mapToLong(x -> x).sum()));

      final Optional<Map.Entry<Integer, Long>> min = backpackIndexToSumExecutionTime.entrySet().stream()
          .min(Comparator.comparingLong(Map.Entry::getValue));
      // dont do it at home
      final int backpackIndexToAdd = min.get().getKey();

      dividedBackpacks.get(backpackIndexToAdd).add(testExecutionInfo);
    }

    return dividedBackpacks;
  }
}
