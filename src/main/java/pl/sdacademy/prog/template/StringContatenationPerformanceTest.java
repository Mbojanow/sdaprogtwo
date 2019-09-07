package pl.sdacademy.prog.template;

import java.util.Random;

public class StringContatenationPerformanceTest extends PerformanceTestTemplate {

  private static final int WARMUP_INTERATION_NUM = 3;
  private static final int INTERATIONS_NUM = 1000;
  private static final int CHAR_NUM = 10000;

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
    String value = "";
    final Random random = new Random();
    final StringBuilder sb = new StringBuilder(CHAR_NUM);
    for (int idx = 0; idx < CHAR_NUM; idx++) {
      sb.append(String.valueOf(Math.abs(random.nextInt() % 10)));
    }
    value = sb.toString();

    // niefektywna implementacja - konkatenacja
//    for (int idx = 0; idx < CHAR_NUM; idx++) {
//      value += String.valueOf(Math.abs(random.nextInt() % 10));
//    }
  }
}
