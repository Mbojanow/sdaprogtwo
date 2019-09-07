package pl.sdacademy.prog.multithreading.booleans;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtomicBooleanMain {
  public static void main(String[] args) throws InterruptedException {


    final List<Thread> threads = Stream.generate(() -> new Thread(new AtomicBooleanThread())).limit(4)
        .collect(Collectors.toList());

    threads.forEach(Thread::start);

    for (final Thread thread : threads) {
      thread.join();
    }

    System.out.println(AtomicBooleanThread.getAtomicBool());
  }
}
