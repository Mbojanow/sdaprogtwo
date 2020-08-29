package pl.sdacademy.prog.cdl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {
  public static void main(String[] args) throws InterruptedException {
    final CountDownLatch countDownLatch = new CountDownLatch(5);
    final AtomicInteger atomicInteger = new AtomicInteger(); // domyślna wartość - 0
//    final List<Thread> threads = Stream.generate(() -> new Thread(new ThreadWithBarrier(countDownLatch, atomicInteger)))
//        .limit(5)
//        .collect(Collectors.toList());
//
//    threads.forEach(Thread::start);

    final List<ThreadWithBarrier> tasks = Stream.generate(() -> new ThreadWithBarrier(countDownLatch, atomicInteger))
        .limit(5)
        .collect(Collectors.toList());

    final ExecutorService executorService = Executors.newFixedThreadPool(4);// ilosc wątkow, mniejsza niż ilość zadań
    tasks.forEach(executorService::submit);

    executorService.shutdown();
  }

//  public void problem() {
//    List<Integer> values = new ArrayList<>();
//
//    Set.of().stream()
//        .filter(x -> x.hashCode() > 0);
//  }
}
