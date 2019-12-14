package pl.sdacademy.prog.cor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TokenRepository {

  private final List<Token> tokens = new ArrayList<>();

  public Optional<Token> findByUsername(final String username) {
    return tokens.stream()
        .filter(token -> token.getName().endsWith(username))
        .findFirst();
  }

  public List<Token> findAll() {
    return tokens;
  }

  public void delete(final Token token) {
    tokens.remove(token);
  }

  public void add(final Token token) {
    tokens.add(token);
  }
}
