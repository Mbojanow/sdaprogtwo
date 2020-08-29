package pl.sdacademy.prog.spam;

import java.util.concurrent.CountDownLatch;

import lombok.SneakyThrows;

public class Thr implements Runnable {

  private final CountDownLatch cdl;


  public Thr(final CountDownLatch cdl) {
    this.cdl = cdl;
  }

  @SneakyThrows
  @Override
  public void run() {
    System.out.println(Thread.currentThread() + " count is: " + cdl.getCount());
    Thread.sleep(1000L);
    cdl.countDown();
    cdl.await();
    System.out.println(Thread.currentThread() + " after count is: " + cdl.getCount());

  }
}
