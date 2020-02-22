package pl.sdacademy.prog.cor;

import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sdacademy.prog.streams.SdaException;

import java.util.Optional;

public class UserCredentialsService implements Authenticator {

  private final UserCredentialsRepository repository;
  private final PasswordEncoder passwordEncoder;

  public UserCredentialsService(final UserCredentialsRepository repository, final PasswordEncoder encoder) {
    this.repository = repository;
    passwordEncoder = encoder;
  }

  public void createCredentials(final String username, final String password) {
    repository.getPassword(username).ifPresent(x -> {throw new SdaException("asd");});
    repository.add(new UserCredentials(username, passwordEncoder.encode(password)));
  }

  public void updateCredentials(final String username, final String newPassword) {
    final String existingPassword = repository.getPassword(username).orElseThrow(SdaException::new);
    if (existingPassword.matches(newPassword)) {
      throw new SdaException("Cannot change to same password");
    }
  }

  public void removeAccount(final String username) {
    repository.getPassword(username).orElseThrow(SdaException::new);
    repository.delete(username);
  }

  @Override
  public boolean matches(final String username, final String password) {
    final Optional<String> existingPassword = repository.getPassword(username);
    if (existingPassword.isEmpty()) {
      return false;
    }
    try {
      return passwordEncoder.matches(password, existingPassword.get());
    } catch (final Exception exp) {
      return false;
    }
  }
}
