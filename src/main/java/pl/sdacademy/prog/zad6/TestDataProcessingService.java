package pl.sdacademy.prog.zad6;

import java.util.*;
import java.util.stream.Collectors;

public class TestDataProcessingService {

    public List<Map<String, Long>> process(final int backpackNum, final Map<String, Long> data) {
        final List<Map<String, Long>> output = new ArrayList<>();
        for (int idx = 0; idx < backpackNum; idx++) {
            output.add(new HashMap<>());
        }

        for (final Map.Entry<String, Long> testData: data.entrySet()) {
            final int backpackWithLeastExecutionTimeIndex = findBackpackIndexWithLeastExecutionTime(output);
            output.get(backpackWithLeastExecutionTimeIndex).put(testData.getKey(), testData.getValue());
        }

        return output;
    }

    private int findBackpackIndexWithLeastExecutionTime(final List<Map<String, Long>> values) {
        final List<Long> sums =  values.stream()
                .map(Map::values)
                .map(v -> v.stream().mapToLong(x -> x).sum())
                .collect(Collectors.toList());

        return sums.indexOf(sums.stream().min(Comparator.naturalOrder()).orElseThrow());
    }
}
