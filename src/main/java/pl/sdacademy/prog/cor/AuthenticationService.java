package pl.sdacademy.prog.cor;

import static java.util.Objects.isNull;

public class AuthenticationService {
  private final Authenticator authenticator;
  private final AuthenticationService authenticationService;

  public AuthenticationService(final Authenticator authenticator, final AuthenticationService authenticationService) {
    this.authenticator = authenticator;
    this.authenticationService = authenticationService;
  }

  public AuthenticationService(final Authenticator authenticator) {
    this.authenticator = authenticator;
    authenticationService = null;
  }

  public boolean authenticate(final String username, final String password) {
    final boolean authenticationResult = authenticator.matches(username, password);
    if (authenticationResult) {
      return true;
    }

    if (isNull(authenticationService)) {
      return false;
    }
    return authenticationService.authenticate(username, password);
  }
}
