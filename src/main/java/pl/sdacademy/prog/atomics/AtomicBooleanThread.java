package pl.sdacademy.prog.atomics;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanThread implements Runnable {

  private AtomicBoolean value;

  public AtomicBooleanThread(final AtomicBoolean value) {
    this.value = value;
  }

  @Override
  public void run() {
    for (int idx = 0; idx < 10000; idx++) {
      // value.get() // 1 operacja
      // !value.get()
      // value.getAndSet(...) // 2 operacja
      synchronized (AtomicBooleanThread.class) {
        value.getAndSet(!value.get());
      }
    }
  }
}
