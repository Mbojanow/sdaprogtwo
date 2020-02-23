package pl.sdacademy.prog.template;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingTestTemplate extends PerformanceTestTemplate {

  @Override
  public int getWarmupIterationsNum() {
    return 2;
  }

  @Override
  public int getIterationsNum() {
    return 10;
  }

  @Override
  public void iteration() {
    final List<Integer> numbers = Stream.generate(() -> new Random().nextInt())
        .limit(1000000)
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());
  }
}
