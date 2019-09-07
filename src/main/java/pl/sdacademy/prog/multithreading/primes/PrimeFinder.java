package pl.sdacademy.prog.multithreading.primes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder implements Runnable {

  private List<Integer> integers;

  public PrimeFinder(final List<Integer> integers) {
    this.integers = integers;
  }

  @Override
  public void run() {
    // szukamy licz pierwszych w liscie o dlugosc co najwyzej 100k

    final List<Integer> primes = new ArrayList<>();
    for (final int value : integers) {
      if(isIntegerPrime(value)) {
        primes.add(value);
      }
    }
    primes.forEach(System.out::println);
  }

  private boolean isIntegerPrime(final int valueToCheck) {
    if (valueToCheck <= 1) {
      return false;
    }

    for (int idx = 2; idx < valueToCheck / 2; idx++) {
      if (valueToCheck % idx == 0) {
        return false;
      }
    }
    return true;
  }
}
