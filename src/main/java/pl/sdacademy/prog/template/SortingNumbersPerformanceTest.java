package pl.sdacademy.prog.template;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.sdacademy.prog.slack.User;

public class SortingNumbersPerformanceTest extends PerformanceTestTemplate {

  private static final int WARMUP_INTERATION_NUM = 3;
  private static final int INTERATIONS_NUM = 1000;
  private static final int INT_NUM = /*(int)1e4*/ 10000;

  //private static final User USER = new User();

  @Override
  protected int getWarmupIterationsNum() {
    return WARMUP_INTERATION_NUM;
  }

  @Override
  protected int getIterationsNum() {
    return INTERATIONS_NUM;
  }

  @Override
  protected void testIteration() {
    final Random random = new Random();
    final List<Integer> generatedNumbers = Stream.generate(random::nextInt)
        .limit(INT_NUM)
        .collect(Collectors.toList());

    generatedNumbers.sort(Comparator.naturalOrder());
  }
}
