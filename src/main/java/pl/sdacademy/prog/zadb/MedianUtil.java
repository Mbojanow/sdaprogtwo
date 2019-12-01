package pl.sdacademy.prog.zadb;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.prog.stra.GenericException;

public class MedianUtil {

  private static int UPPER_BOUND_INCLUSIVE = 1000;

  public static <T extends Number> Double findMedian(final Collection<T> values) {
    final boolean hasIncorrectValue = values.stream()
        .anyMatch(elem -> Math.abs(elem.doubleValue()) > UPPER_BOUND_INCLUSIVE);
    if (hasIncorrectValue || values.isEmpty()) {
      throw new GenericException("Input collection has invalid elements or is empty");
    }

    final List<Double> sortedValues = values.stream()
        .map(Number::doubleValue)
        .sorted()
        .collect(Collectors.toList());

    if (sortedValues.size() % 2 == 1) {
      final int medianIndex = sortedValues.size() / 2;
      return (double)sortedValues.get(medianIndex);
    } else {
      final int firstIndex = (sortedValues.size() / 2) - 1;
      final int secondIndex = sortedValues.size() / 2;
      return (sortedValues.get(firstIndex) + sortedValues.get(secondIndex)) / 2.0;
    }
  }
}
