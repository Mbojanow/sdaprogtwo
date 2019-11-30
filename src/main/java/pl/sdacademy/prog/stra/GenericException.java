package pl.sdacademy.prog.stra;

public class GenericException extends RuntimeException {
  public GenericException() {
    super();
  }

  public GenericException(final String message) {
    super(message);
  }

  public GenericException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public GenericException(final Throwable cause) {
    super(cause);
  }

  protected GenericException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
