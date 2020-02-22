package pl.sdacademy.prog;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

class UserTest {

  @Test
  void asd() {
    PasswordEncoder bencoder = new BCryptPasswordEncoder();
    PasswordEncoder sencoder = new SCryptPasswordEncoder();
    PasswordEncoder nencoder = NoOpPasswordEncoder.getInstance();

    final String p1 = bencoder.encode("Kondor_123");
    final String p2 = sencoder.encode("Kondor_123");
    final String p3 = nencoder.encode("Kondor_123");

    System.out.println("x");
  }

}