package pl.sdacademy.prog.booleanthreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanDemo {
  public static void main(String[] args) throws InterruptedException {
    final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    final Thread threadA = new Thread(new AtomicBooleanUsageThread(atomicBoolean));
    final Thread threadB = new Thread(new AtomicBooleanUsageThread(atomicBoolean));
    threadA.start();
    threadB.start();
    threadA.join();
    threadB.join();
    System.out.println(atomicBoolean.get());
  }
}
