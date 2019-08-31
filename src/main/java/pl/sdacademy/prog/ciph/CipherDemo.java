package pl.sdacademy.prog.ciph;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CipherDemo {
  public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, IOException {
    final String inputFile = args[0];
    final String outputFile = args[1];
    final int mode = Integer.valueOf(args[2]);
    final long seed = Long.valueOf(args[3]);

    final SymmetricEncryptionService encryptionService = new SymmetricEncryptionService();

    encryptionService.performEncryption(inputFile, outputFile, mode, seed);
  }
}
