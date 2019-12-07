package pl.sdacademy.prog.threads.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownThread implements Runnable {

  private AtomicInteger atomicInteger;
  private CountDownLatch countDownLatch;

  public CountDownThread(final AtomicInteger atomicInteger, final CountDownLatch countDownLatch) {
    this.atomicInteger = atomicInteger;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    final long millisToSleep = Math.abs(new Random().nextLong() % 1000);
    try {
      Thread.sleep(millisToSleep);
    } catch (InterruptedException e) {}
    if (atomicInteger.incrementAndGet() == 5) {
      System.out.println("I am the last thread");
    }
    countDownLatch.countDown();
    System.out.println("Counted down");
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
    }
    System.out.println("Exiting");
  }
}
