package pl.sdacademy.prog.strA;

public class AccountDataException extends RuntimeException {
    public AccountDataException() {
        super();
    }

    public AccountDataException(final String message) {
        super(message);
    }
}
