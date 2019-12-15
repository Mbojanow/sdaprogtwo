package pl.sdacademy.prog.cor;

public class CORDemo {

  public static void main(String[] args) {

    final UserCredentialsRepository userCredentialsRepository = new UserCredentialsRepository();
    final UserCredentialsService userCredentialsService =
        new UserCredentialsService(PasswordEncoder.getBCryptPasswordEncoder(),
        userCredentialsRepository);

    final TokenRepository tokenRepository = new TokenRepository();
    final TokenService tokenService = new TokenService(tokenRepository);

    final AuthenticationService authenticationServiceToken = new AuthenticationService(tokenService);
    final AuthenticationService authenticationServiceUnp = new AuthenticationService(userCredentialsService,
        authenticationServiceToken);

    userCredentialsService.createCredentials("Andrzej", "andy_1234");
    final Token grazyna = tokenService.generate("Andrzejy");

    final boolean result = authenticationServiceUnp.authenticate("Andrzej",
        grazyna.getValue().toString());
    System.out.println(result);
  }
}
