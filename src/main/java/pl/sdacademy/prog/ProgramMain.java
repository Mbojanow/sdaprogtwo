package pl.sdacademy.prog;

import java.util.Optional;

public class ProgramMain {
  public static void main(String[] args) {
    System.out.println("UDAŁO SIE ZAIMPORTOWAC PROJEKT POPRAWNIE");

    final Optional<Integer> x = Optional.of(1).or(() -> Optional.of(2));
  }
}
