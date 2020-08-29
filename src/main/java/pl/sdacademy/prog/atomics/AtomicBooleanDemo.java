package pl.sdacademy.prog.atomics;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicBooleanDemo {
  public static void main(String[] args) {
    final AtomicBoolean atomicBoolean =  new AtomicBoolean(false);
    final List<Thread> threads = Stream.generate(() -> new Thread(new AtomicBooleanThread(atomicBoolean)))
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

    System.out.println(atomicBoolean.get());
  }
}
