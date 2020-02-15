package pl.sdacademy.prog.increments;

public class IncrementingThread implements Runnable {

  private PackedInt packedInt;

  public IncrementingThread(final PackedInt packedInt) {
    this.packedInt = packedInt;
  }

  @Override
  public void run() {
    for (int idx = 0; idx < 10000; idx++) {
      packedInt.increment();
    }
    System.out.println(packedInt.getValue());
  }
}
