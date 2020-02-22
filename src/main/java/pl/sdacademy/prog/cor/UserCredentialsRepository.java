package pl.sdacademy.prog.cor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCredentialsRepository {
  private List<UserCredentials> allCredentials = new ArrayList<>();

  public void add(final UserCredentials credentials) {
    allCredentials.add(credentials);
  }

  public void update(final UserCredentials credentials) {
    allCredentials.removeIf(creds ->  creds.getUsername().equals(credentials.getUsername()));
    allCredentials.add(credentials);
  }

  public void delete(final String username) {
    allCredentials.removeIf(creds -> creds.getUsername().equals(username));
  }

  public Optional<String> getPassword(final String username) {
    return allCredentials.stream()
        .map(UserCredentials::getUsername)
        .filter(existingUsername -> existingUsername.equals(username))
        .findFirst();
  }
}
