package pl.sdacademy.prog.strA;

public class AccountDataException extends RuntimeException {

    public AccountDataException(final String message) {
        super(message);
    }

    public AccountDataException(final Throwable cause) {
        super(cause);
    }
}
