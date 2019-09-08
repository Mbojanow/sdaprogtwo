package pl.sdacademy.prog.day6.strategy;

public class SdaException extends RuntimeException {
  public SdaException() {
    super();
  }

  public SdaException(final String message) {
    super(message);
  }

  public SdaException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
