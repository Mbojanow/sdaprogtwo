package pl.sdacademy.prog.strategy;

public class StrategyException extends RuntimeException {
  public StrategyException(final String message) {
    super(message);
  }

  public StrategyException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
