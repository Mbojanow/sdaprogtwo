package pl.sdacademy.prog.cdl;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.SneakyThrows;

public class ThreadWithBarrier implements Runnable {

  private final CountDownLatch countDownLatch;
  private final AtomicInteger atomicInteger;

  public ThreadWithBarrier(final CountDownLatch countDownLatch, final AtomicInteger atomicInteger) {
    this.countDownLatch = countDownLatch;
    this.atomicInteger = atomicInteger;
  }

  @Override
  @SneakyThrows // wygodne w czasie eksperymentowania. w kodzie "produkcyjnym" -> nie używamy
  // podmienia typ wyjątku -> z checked, na uncheck -> NIE MUSIMY obslugiwac wyjątku.
  public void run() {
    // czekać co najwyżej 1 sekund
    // zwięszyć atomicInteger
    // uderzyć w "barierę"
    // poczekać na barierze

    Thread.sleep(Math.abs(new Random().nextLong() % 1000));
    atomicInteger.incrementAndGet();
    System.out.println("Current value " + atomicInteger.get());
    countDownLatch.countDown();
    System.out.println("Count down hit");
    countDownLatch.await();
    System.out.println("Barrier broken");
  }
}
