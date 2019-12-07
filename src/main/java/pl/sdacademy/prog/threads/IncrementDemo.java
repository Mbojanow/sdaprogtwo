package pl.sdacademy.prog.threads;

public class IncrementDemo {
  public static void main(String[] args) throws InterruptedException {
    final PackedInt packedInt = new PackedInt();
    final Thread threadA = new Thread(new IncrementingThread(packedInt));
    final Thread threadB = new Thread(new IncrementingThread(packedInt));

    threadA.start();
    //Thread.sleep(500L);
    threadB.start();

    threadA.join();
    threadB.join();
    System.out.println(packedInt.getValue());
  }
}
