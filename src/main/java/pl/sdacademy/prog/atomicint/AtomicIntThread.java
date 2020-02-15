package pl.sdacademy.prog.atomicint;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntThread implements Runnable {

  private AtomicInteger atomicInteger;

  public AtomicIntThread(final AtomicInteger atomicInteger) {
    this.atomicInteger = atomicInteger;
  }

  @Override
  public void run() {
    for (int idx = 0; idx < 10000; idx++) {
      atomicInteger.incrementAndGet();
    }
    System.out.println(Thread.currentThread().getId() + " " + atomicInteger.get());
  }
}
