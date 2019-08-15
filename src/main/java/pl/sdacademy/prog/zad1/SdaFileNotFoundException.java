package pl.sdacademy.prog.zad1;

public class SdaFileNotFoundException extends RuntimeException {

    public SdaFileNotFoundException(final String message) {
        super(message);
    }

    public SdaFileNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
