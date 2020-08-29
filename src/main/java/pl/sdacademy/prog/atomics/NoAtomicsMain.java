package pl.sdacademy.prog.atomics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoAtomicsMain {
  public static void main(String[] args) {
    BooleanWrapper booleanWrapper = new BooleanWrapper(false);
    final List<Thread> threads = Stream.generate(() -> new Thread(new NoAtomicsBooleanThread(booleanWrapper)))
        .limit(3)
        .collect(Collectors.toList());

    threads.forEach(Thread::start);
    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    System.out.println(booleanWrapper.isValue());
  }
}
