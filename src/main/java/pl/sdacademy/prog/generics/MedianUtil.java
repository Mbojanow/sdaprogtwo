package pl.sdacademy.prog.generics;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.prog.streams.SdaException;

public class MedianUtil {

  private static final int UPPER_BOUND_VALUE = 1000;

  public static <T extends Number> Double findMedian(final List<T> values) {
    if (values.isEmpty()) {
      throw new SdaException("Cannot calculate median from empty list");
    }

    if (values.stream().anyMatch(value -> Math.abs(value.doubleValue()) > UPPER_BOUND_VALUE)) {
      throw new SdaException("At least one value does not match bound condition");
    }

    final List<T> sortedValues = values.stream()
        .sorted(Comparator.comparingDouble(Number::doubleValue))
        .collect(Collectors.toList());

    if (sortedValues.size() % 2 == 1) {
      return sortedValues.get(sortedValues.size() / 2).doubleValue();
    }
    final int firstIndex = sortedValues.size() / 2 - 1;
    return (sortedValues.get(firstIndex).doubleValue() +
        sortedValues.get(firstIndex + 1).doubleValue()) / 2;

//    final List<Double> sortedValues = values.stream()
//        .map(number -> number.doubleValue())
//        .sorted()
//        .collect(Collectors.toList());
//
//    if (sortedValues.size() % 2 == 1) {
//      return (double)sortedValues.get(sortedValues.size() / 2);
//    }
//    final int firstIndex = sortedValues.size() / 2 - 1;
//    return ((double)sortedValues.get(firstIndex) + sortedValues.get(firstIndex + 1)) / 2;
  }

  public static void main(String[] args) {
    final List<Integer> ints = List.of(1, 2, 3, 4);
    final Double median = MedianUtil.findMedian(ints);
    System.out.println(median);

    final List<Long> longs = List.of(2L, 3L, 5L);
    final Double median2 = MedianUtil.findMedian(longs);
    System.out.println(median2);

    final List<Double> doubles = List.of(1.1, 2.2, 3.3, 4.4);
    final Double median3 = MedianUtil.findMedian(doubles);
    System.out.println(median3);
  }
}
