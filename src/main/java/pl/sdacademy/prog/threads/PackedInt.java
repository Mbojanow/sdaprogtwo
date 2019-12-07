package pl.sdacademy.prog.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class PackedInt {
  private AtomicInteger value = new AtomicInteger(0);

  public Integer getValue() {
    return value.get();
  }

  //synchronized nie jest wymagany
  public void increment() {
    value.incrementAndGet();
  }
}
