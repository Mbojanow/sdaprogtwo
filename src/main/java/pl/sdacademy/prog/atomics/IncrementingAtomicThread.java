package pl.sdacademy.prog.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementingAtomicThread implements Runnable {

  private AtomicInteger value;

  public IncrementingAtomicThread(final AtomicInteger value) {
    this.value = value;
  }

  @Override
  public void run() {
    for (int idx = 0; idx < 10000; idx++) {
      // brak tu bloku synchronized
      value.incrementAndGet(); // operacja ++value
    }
  }
}
