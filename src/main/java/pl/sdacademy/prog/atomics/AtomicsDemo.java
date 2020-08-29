package pl.sdacademy.prog.atomics;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicsDemo {
  public static void main(String[] args) {
    final AtomicInteger value = new AtomicInteger(0);
    final List<Thread> threads = Stream.generate(() -> new Thread(new IncrementingAtomicThread(value)))
        .limit(4)
        .collect(Collectors.toList());

    threads.forEach(Thread::start);
    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    System.out.println(value.get());
  }
}
