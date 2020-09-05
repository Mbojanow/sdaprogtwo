package pl.sdacademy.prog.strategy;

// double checked -> lazy do aplikacji wielowatkowych
public class NoOpTextModificationStrategy implements TextModificationService {

  private static NoOpTextModificationStrategy instance = null;

  private NoOpTextModificationStrategy() {}

  public static NoOpTextModificationStrategy getInstance() {
    if (instance == null) {
      synchronized (NoOpTextModificationStrategy.class) {
        if (instance == null) {
          instance = new NoOpTextModificationStrategy();
        }
      }
    }
    return instance;
  }

  @Override
  public String modify(final String toModify) {
    return toModify;
  }
}
