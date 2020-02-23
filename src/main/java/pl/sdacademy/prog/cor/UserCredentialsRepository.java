package pl.sdacademy.prog.cor;

//dao == repository

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCredentialsRepository {
  private List<UserCredentials> allCredentials = new ArrayList<>();

  public void add(final UserCredentials credentials) {
    allCredentials.add(credentials);
  }

  public void update(final UserCredentials userCredentials) {
    delete(userCredentials.getUsername());
    add(userCredentials);
  }

  public void delete(final String username) {
    allCredentials.removeIf(credentials -> credentials.getUsername()
        .equals(username));
  }

  public Optional<String> getPassword(final String username) {
    return allCredentials.stream()
        .filter(userCredentials -> userCredentials.getUsername().equals(username))
        .map(UserCredentials::getPassword)
        .findFirst();
  }
}
