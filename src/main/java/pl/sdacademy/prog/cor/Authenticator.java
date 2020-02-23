package pl.sdacademy.prog.cor;

public interface Authenticator {
  boolean matches(final String username, final String password);
}
