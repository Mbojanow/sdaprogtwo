package pl.sdacademy.prog.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CoundDownLatchThread implements Runnable {

  private static AtomicInteger counter = new AtomicInteger(0);

  private CountDownLatch countDownLatch;

  public CoundDownLatchThread(final CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(Math.abs(new Random().nextLong() % 5000));
      // nie wymaga bloku synchronized
      countDownLatch.countDown();
      System.out.println("I am thread " + counter.incrementAndGet() + " that did countdown");
      countDownLatch.await();
      System.out.println("EXITING");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
