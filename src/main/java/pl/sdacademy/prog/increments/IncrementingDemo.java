package pl.sdacademy.prog.increments;

public class IncrementingDemo {
  public static void main(String[] args) throws InterruptedException {
    final PackedInt packedInt = new PackedInt(0);
    final Thread threadA = new Thread(new IncrementingThread(packedInt));
    final Thread threadB = new Thread(new IncrementingThread(packedInt));

    threadA.start();
    threadB.start();
    threadA.join();
    threadB.join();

  }
}
