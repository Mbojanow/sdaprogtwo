package pl.sdacademy.prog.cor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class CORDemo {
  public static void main(String[] args) {
    final UserCredentialsRepository userCredentialsRepository = new UserCredentialsRepository();
    final UserCredentialsService bUserCredenctialsService = new UserCredentialsService(userCredentialsRepository, new BCryptPasswordEncoder());
    final UserCredentialsService sUserCredenctialsService = new UserCredentialsService(userCredentialsRepository, new SCryptPasswordEncoder());
    final UserCredentialsService noopUserCredenctialsService = new UserCredentialsService(userCredentialsRepository, NoOpPasswordEncoder.getInstance());

    final AuthenticationService lastAuthenticationService = new AuthenticationService(noopUserCredenctialsService);
    final AuthenticationService middleAuthenticationService = new AuthenticationService(bUserCredenctialsService, lastAuthenticationService);
    final AuthenticationService firstAuthenticationService = new AuthenticationService(sUserCredenctialsService, middleAuthenticationService);

    bUserCredenctialsService.createCredentials("userB", "Kondor_123");
    sUserCredenctialsService.createCredentials("userS", "Kondor_123");
    noopUserCredenctialsService.createCredentials("userN", "Kondor_123");

    final boolean authResult = firstAuthenticationService.authenticate("userN", "Kondor_123");
    System.out.println(authResult);
  }
}
