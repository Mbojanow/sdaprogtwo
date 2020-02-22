package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NoOpModificationStrategy implements TextModificationStrategy {

  private static NoOpModificationStrategy instance;

  public static NoOpModificationStrategy getInstance() {
    if (instance == null) {
      synchronized (NoOpModificationStrategy.class) {
        if (instance == null) {
          instance = new NoOpModificationStrategy();
        }
      }
    }
    return instance;
  }

  @Override
  public String modify(final String input) {
    return input;
  }
}
