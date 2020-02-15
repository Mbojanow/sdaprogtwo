package pl.sdacademy.prog.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {
  public static void main(String[] args) {
    final int cdlCounter = 5;
    final CountDownLatch countDownLatch = new CountDownLatch(cdlCounter);
    final List<Runnable> threads = Stream
        .generate(() -> new CoundDownLatchThread(countDownLatch))
        .limit(cdlCounter)
        .collect(Collectors.toList());

    final ExecutorService executorService = Executors.newFixedThreadPool(cdlCounter - 1);
    threads.forEach(executorService::submit);
    executorService.shutdown();
  }
}
