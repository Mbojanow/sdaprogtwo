package pl.sdacademy.prog.cor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class CorDemo {
  public static void main(String[] args) {
    final UserCredentialsRepository repository = new UserCredentialsRepository();
    final UserCredentialsService serviceB = new UserCredentialsService(repository,
        new BCryptPasswordEncoder());
    final UserCredentialsService serviceS = new UserCredentialsService(repository,
        new SCryptPasswordEncoder());
    final UserCredentialsService serviceN = new UserCredentialsService(repository,
        NoOpPasswordEncoder.getInstance());

    final AuthenticationService lastElement = new AuthenticationService(serviceN);
    final AuthenticationService midElement = new AuthenticationService(serviceS,
        lastElement);
    final AuthenticationService firstElement = new AuthenticationService(serviceB,
        midElement);

    serviceB.createCredentials("andrzej", "Haslo_123");
    serviceS.createCredentials("janusz", "No_siema_123");
    serviceN.createCredentials("grazyna", "qwerty_123");

    final boolean andrzejResult = firstElement.authenticate("andrzej", "Haslo_123");
    System.out.println(andrzejResult);
    final boolean januszResult = firstElement.authenticate("janusz", "No_siema_123");
    System.out.println(januszResult);
    final boolean grazynaResult = firstElement.authenticate("grazyna", "qwerty_1234");
    System.out.println(grazynaResult);
  }
}
