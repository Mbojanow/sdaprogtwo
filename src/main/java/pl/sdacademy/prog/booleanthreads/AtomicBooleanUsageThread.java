package pl.sdacademy.prog.booleanthreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanUsageThread implements Runnable {

  private final AtomicBoolean atomicBoolean;

  public AtomicBooleanUsageThread(final AtomicBoolean atomicBoolean) {
    this.atomicBoolean = atomicBoolean;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      synchronized (AtomicBooleanUsageThread.class) {
        atomicBoolean.getAndSet(!atomicBoolean.get());
      }
    }
  }
}
