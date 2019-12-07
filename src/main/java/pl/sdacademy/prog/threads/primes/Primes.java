package pl.sdacademy.prog.threads.primes;

public class Primes {

  public boolean isPrime(final Integer value) {
    for (int idx = 2; idx <= Math.sqrt(value); idx++) {
      if (value % idx == 0) {
        return false;
      }
    }
    return true;
  }
}
