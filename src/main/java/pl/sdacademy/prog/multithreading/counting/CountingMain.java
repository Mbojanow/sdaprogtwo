package pl.sdacademy.prog.multithreading.counting;

import java.util.concurrent.atomic.AtomicBoolean;

public class CountingMain {
  public static void main(String[] args) throws InterruptedException {

    final Thread thr1 = new Thread(new IncrementingThread());
    final Thread thr2 = new Thread(new IncrementingThread());

    thr1.start();
    Thread.sleep(500L);
    thr2.start();

    thr1.join();
    thr2.join();

    System.out.println(IncrementingThread.getValue());
  }
}
