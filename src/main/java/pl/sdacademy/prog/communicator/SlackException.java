package pl.sdacademy.prog.communicator;

public class SlackException extends RuntimeException {
  public SlackException() {
    super();
  }

  public SlackException(final String message) {
    super(message);
  }

  public SlackException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public SlackException(final Throwable cause) {
    super(cause);
  }

  protected SlackException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
