package pl.sdacademy.prog.atomics;

public class NoAtomicsBooleanThread implements Runnable {

  private BooleanWrapper booleanWrapper;

  public NoAtomicsBooleanThread(final BooleanWrapper booleanWrapper) {
    this.booleanWrapper = booleanWrapper;
  }

  @Override
  public void run() {
    synchronized (NoAtomicsBooleanThread.class) {
      for (int idx = 0; idx < 10001; idx++) {
        booleanWrapper.setValue(!booleanWrapper.isValue());
      }
    }
  }
}
