package pl.sdacademy.prog.cor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordEncoder {

    private static final BCryptPasswordEncoder INSTANCE = new BCryptPasswordEncoder();

    public static BCryptPasswordEncoder getBCryptPasswordEncoder() {
      return INSTANCE;
    }
}
