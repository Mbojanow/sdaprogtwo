package pl.sdacademy.prog.currencies;

public class SdaException extends RuntimeException {
  public SdaException(final String message, final Throwable exp) {
    super(message, exp);
  }
}
