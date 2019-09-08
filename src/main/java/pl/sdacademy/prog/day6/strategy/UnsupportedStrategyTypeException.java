package pl.sdacademy.prog.day6.strategy;

public class UnsupportedStrategyTypeException extends RuntimeException {

  public UnsupportedStrategyTypeException() {
    super();
  }

  public UnsupportedStrategyTypeException(final String message) {
    super(message);
  }

  public UnsupportedStrategyTypeException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
