package pl.sdacademy.prog.memorymodel;

import java.util.Random;

public class SimpleThread implements Runnable {

  //() -> new Data("key", "value") -> Supplier
  private static final ThreadLocal<Data> data = ThreadLocal.withInitial(() -> new Data("key", "value" + new Random().nextInt()));
  private static final Data data2 = new Data("key", "value" + new Random().nextInt());

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getId() + " " + data.get());
    System.out.println(Thread.currentThread().getId() + " " + data2);
  }
}
