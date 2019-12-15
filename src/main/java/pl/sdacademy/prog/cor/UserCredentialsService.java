package pl.sdacademy.prog.cor;

import java.util.Base64;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pl.sdacademy.prog.stra.GenericException;

public class UserCredentialsService implements Authenticator {

  private final BCryptPasswordEncoder passwordEncoder;
  private final UserCredentialsRepository userCredentialsRepository;

  public UserCredentialsService(final BCryptPasswordEncoder passwordEncoder, final UserCredentialsRepository userCredentialsRepository) {
    this.passwordEncoder = passwordEncoder;
    this.userCredentialsRepository = userCredentialsRepository;
  }

  /*
  Stwórz obiekt UsernameAndPasswordService, który ma możliwość zapisania danych użytkownika,
  pobrania ich, usunąć je lub sprawdzić czy hasło jest zgodne z wejściowym dla danego użytkownika.
  Hasła ZAWSZE powinni być enkryptowane za pomocą enkodera Bcrypt i
   następnie enkodowane za pomocą Base64.
   */

  public void createCredentials(final String username, final String password) {
    final Optional<UserCredentials> optionalCredentials = userCredentialsRepository.findByUsername(username);
    if (optionalCredentials.isPresent()) {
      throw new GenericException("User "  + username + " already has password");
    }

    final String encodedEncryptedPassword = Base64.getEncoder()
        .encodeToString(passwordEncoder.encode(password).getBytes());
    userCredentialsRepository.add(new UserCredentials(username, encodedEncryptedPassword));
  }

  public UserCredentials getByUsername(final String username) {
    return userCredentialsRepository.findByUsername(username)
        .orElseThrow(() -> new GenericException("credentials for user " + username + " not found"));
  }

  public void delete(final String username) {
    userCredentialsRepository.remove(username);
  }

  public boolean matches(final String username, final String password) {
    final Optional<UserCredentials> userCredentialsOptional =
        userCredentialsRepository.findByUsername(username);
    if (userCredentialsOptional.isEmpty()) {
      return false;
    }

    final String encodedEncryptedPassword = userCredentialsOptional.get().getPassword();
    final String dbHashedPassword = new String(Base64.getDecoder().decode(encodedEncryptedPassword));
    //final String inputHashedPassword = passwordEncoder.encode(password);
    return passwordEncoder.matches(password, dbHashedPassword);
  }
}
