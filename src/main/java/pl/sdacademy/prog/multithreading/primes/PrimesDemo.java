package pl.sdacademy.prog.multithreading.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimesDemo {
  public static void main(String[] args) {
    final Random random = new Random();
    final List<Integer> integers = Stream.generate(() -> Math.abs(random.nextInt() % 1000000))
        .limit(40000)
        .collect(Collectors.toList());

    final List<Integer> argsA = getFromInputList(integers, 0, 10000);
    final List<Integer> argsB = getFromInputList(integers, 10000, 20000);
    final List<Integer> argsC = getFromInputList(integers, 20000, 30000);
    final List<Integer> argsD = getFromInputList(integers, 30000, 40000);

    final ExecutorService executorService = Executors.newFixedThreadPool(2);

    final Runnable r1 = new PrimeFinder(argsA);
    final Runnable r2 = new PrimeFinder(argsB);
    final Runnable r3 = new PrimeFinder(argsC);
    final Runnable r4 = new PrimeFinder(argsD);

    executorService.submit(r1);
    executorService.submit(r2);
    executorService.submit(r3);
    executorService.submit(r4);

    executorService.shutdown();
  }

  private static List<Integer> getFromInputList(final List<Integer> input, final int fromIndex, final int toIndex) {
    final List<Integer> output = new ArrayList<>();
    for (int i = fromIndex; i < toIndex; i++) {
      output.add(input.get(i));
    }
    return output;
  }
}
