package pl.sdacademy.prog.executors;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersSearchThread implements Runnable {

  private final List<Integer> values;

  public PrimeNumbersSearchThread(final List<Integer> values) {
    this.values = values;
  }

  @Override
  public void run() {
    final List<Integer> primes = new ArrayList<>();
    for (final Integer valueToCheck : values) {
      if (isPrime(valueToCheck)) {
        primes.add(valueToCheck);
      }
    }
    System.out.println(Thread.currentThread().getId() + " found " + primes.size() + " primes.");
  }

  private boolean isPrime(final int valueToCheck) {
    for (int idx = 2; idx < Math.sqrt(valueToCheck); idx++) {
      if (valueToCheck % idx == 0) {
        return false;
      }
    }
    return true;
  }
}
