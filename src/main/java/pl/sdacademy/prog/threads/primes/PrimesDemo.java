package pl.sdacademy.prog.threads.primes;

import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimesDemo {
  public static void main(String[] args) {
    final List<Integer> allNumbersToCheck = Stream
        .generate(() -> Math.abs(new Random().nextInt()))
        .limit(400000).collect(Collectors.toList());

    // [ , )
    final List<Integer> listA = allNumbersToCheck.subList(0, 100000);
    final List<Integer> listB = allNumbersToCheck.subList(100000, 200000);
    final List<Integer> listC = allNumbersToCheck.subList(200000, 300000);
    final List<Integer> listD = allNumbersToCheck.subList(300000, 400000);

    final Primes primesService = new Primes();

    final ExecutorService executorService = Executors.newFixedThreadPool(2);

    final Thread threadA = new Thread(new PrimeAmountCheckerThread(listA, primesService));
    final Thread threadB = new Thread(new PrimeAmountCheckerThread(listB, primesService));
    final Thread threadC = new Thread(new PrimeAmountCheckerThread(listC, primesService));
    final Thread threadD = new Thread(new PrimeAmountCheckerThread(listD, primesService));

    executorService.execute(threadA);
    executorService.execute(threadB);
    executorService.execute(threadC);
    executorService.execute(threadD);

    executorService.shutdown();
  }
}
