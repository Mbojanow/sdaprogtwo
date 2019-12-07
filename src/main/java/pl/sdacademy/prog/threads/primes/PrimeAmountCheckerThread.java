package pl.sdacademy.prog.threads.primes;

import java.util.List;

public class PrimeAmountCheckerThread implements Runnable {

  private List<Integer> valuesToCheck;
  private Primes primes;

  public PrimeAmountCheckerThread(final List<Integer> valuesToCheck,
                                  final Primes primes) {
    this.valuesToCheck = valuesToCheck;
    this.primes = primes;
  }

  @Override
  public void run() {
    final long primesAmount = valuesToCheck.stream()
        .filter(value -> this.primes.isPrime(value))
        .count();
    System.out.println("Amount of primes found: " + primesAmount);
  }
}
