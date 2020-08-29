package pl.sdacademy.prog.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorsDemo {
  public static void main(String[] args) {
    final Random random = new Random();
    final List<Integer> numbers = Stream.generate(() -> Math.abs(random.nextInt()))
        .limit(4_000_000)
        .collect(Collectors.toList());

    // to nie my tworzymy obiekty Thread.
    final ExecutorService executorService = Executors.newFixedThreadPool(2);

    List<Runnable> tasks = new ArrayList<>();
    for (int taskIdx = 0; taskIdx < 4; taskIdx++) {
      tasks.add(new PrimeNumbersSearchThread(numbers.subList(1_000_000 * taskIdx, 999_999 + 1_000_000 * taskIdx)));
    }

    tasks.forEach(executorService::submit);
    executorService.shutdown(); // czeka, aż wszystkie zadania zostaną wykonane -> potem zamyka pule wątków
  }
}
