package pl.sdacademy.prog.cor;

import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sdacademy.prog.streams.SdaException;

import java.util.Optional;

public class UserCredentialsService<T extends PasswordEncoder> implements Authenticator {

  private final UserCredentialsRepository repository;
  private final PasswordEncoder passwordEncoder;

  public UserCredentialsService(final UserCredentialsRepository repository, final T encoder) {
    this.repository = repository;
    passwordEncoder = encoder;
  }

  public void createCredentials(final String username, final String password) {
    repository.getPassword(username).ifPresent(x -> {throw new SdaException("asd");});
    repository.add(new UserCredentials(username, password));
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
    return passwordEncoder.matches(password, existingPassword.get());
  }
}
