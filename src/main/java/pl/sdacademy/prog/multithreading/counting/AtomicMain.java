package pl.sdacademy.prog.multithreading.counting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicMain {

  public static void main(String[] args) throws InterruptedException {
    final List<Thread> threads = Stream
        .generate(() -> new Thread(new IncrementingThreadWithAtomic()))
        .limit(4).collect(Collectors.toList());

    threads.forEach(Thread::start);
    for (Thread thread : threads) {
      thread.join();
    }

    System.out.println(IncrementingThreadWithAtomic.getValue());
  }
}
