package pl.sdacademy.prog.multithreading.booleans;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanThread implements Runnable {

  private static final int ITERATION_NUM = 10000;
  private static final AtomicBoolean atomicBool = new AtomicBoolean(false);

  @Override
  public void run() {
    for (int i = 0; i < ITERATION_NUM; i++) {
      synchronized (AtomicBooleanThread.class) {
        final boolean actualValue = atomicBool.get();
        atomicBool.set(!actualValue);
      }
    }
  }

  public static AtomicBoolean getAtomicBool() {
    return atomicBool;
  }
}
