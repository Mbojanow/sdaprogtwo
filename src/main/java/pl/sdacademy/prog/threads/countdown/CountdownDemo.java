package pl.sdacademy.prog.threads.countdown;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountdownDemo {
  public static void main(String[] args) {
    final AtomicInteger atomicInteger = new AtomicInteger(0);
    final CountDownLatch countDownLatch = new CountDownLatch(5);

    final List<Thread> threads = Stream
        .generate(() -> new Thread(new CountDownThread(atomicInteger, countDownLatch)))
        .limit(5)
        .collect(Collectors.toList());

    final ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (final Thread thread : threads) {
      executorService.execute(thread);
    }

    executorService.shutdown();

//    threads.forEach(Thread::start);
//    threads.forEach(t -> {
//      try {
//        t.join();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    });
  }
}
