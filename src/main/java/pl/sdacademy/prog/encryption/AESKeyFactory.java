package pl.sdacademy.prog.encryption;

import java.security.Key;
import java.util.Random;

import javax.crypto.spec.SecretKeySpec;

public class AESKeyFactory {

  private static final int KEY_LENGTH_IN_BYTES = 32;
  private static final String ALGORITHM_NAME = "AES";

  public Key createAES256BitKey(final long seed) {
    final byte[] keyValue = new byte[KEY_LENGTH_IN_BYTES];
    new Random(seed).nextBytes(keyValue);
    return new SecretKeySpec(keyValue, ALGORITHM_NAME);
  }
}
