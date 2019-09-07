package pl.sdacademy.prog.multithreading.counting;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementingThreadWithAtomic implements Runnable {

  private static final int ITERATION_NUM = 100;
  private static final AtomicInteger value = new AtomicInteger(0);

  @Override
  public void run() {
    for (int i = 0; i < ITERATION_NUM; i++) {
      value.incrementAndGet();
    }
  }

  public static AtomicInteger getValue() {
    return value;
  }
}
