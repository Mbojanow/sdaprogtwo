package pl.sdacademy.prog.primes;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimesExecutorServiceDemo {
  public static void main(String[] args) {

    final ExecutorService executorService = Executors.newFixedThreadPool(2);

    final List<Integer> numbersToCheck = IntStream.range(0, 400000).boxed().collect(Collectors.toList());


    final int counter[] = {0};
    final int limit = numbersToCheck.size() / 100000
        + (numbersToCheck.size() % 100000 == 0 ? 0 : 1);
    final List<PrimesThread> threads = Stream.generate(() -> new PrimesThread(numbersToCheck, counter[0]++))
        .limit(limit)
        .collect(Collectors.toList());

    final long startTimestamp = System.currentTimeMillis();
    threads.forEach(executorService::submit);
    executorService.shutdown();
    final long endTimestamp = System.currentTimeMillis();
  }
}
