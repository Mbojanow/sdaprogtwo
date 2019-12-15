package pl.sdacademy.prog.cor;

import java.time.LocalDateTime;
import java.util.UUID;

public class CORDemo {

  public static void main(String[] args) {

    final UserCredentialsRepository userCredentialsRepository = new UserCredentialsRepository();
    final Authenticator userCredentialsService =
        new UserCredentialsService(PasswordEncoder.getBCryptPasswordEncoder(),
        userCredentialsRepository);
    final UserCredentials userCredentials = new UserCredentials("Andrzej", "andy_123");

    final TokenRepository tokenRepository = new TokenRepository();
    final Authenticator tokenService = new TokenService(tokenRepository);
    final Token token = new Token("grazyna", UUID.randomUUID(),
        LocalDateTime.now().plusMinutes(1));

    final AuthenticationService authenticationServiceToken = new AuthenticationService(tokenService);
    final AuthenticationService authenticationServiceUnp = new AuthenticationService(tokenService,
        authenticationServiceToken);

  }
}
