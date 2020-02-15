package pl.sdacademy.prog.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AESEncryptionDemo {
  ///Users/michalbojanowski/work/sdaprogtwo/src/main/resources/input.txt
  // /Users/michalbojanowski/work/sdaprogtwo/src/main/resources/output 1 123

  ///Users/michalbojanowski/work/sdaprogtwo/src/main/resources/output
  // /Users/michalbojanowski/work/sdaprogtwo/src/main/resources/output2 2 123
  public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
    final String inputFile = args[0];
    final String output = args[1];
    final int mode = Integer.parseInt(args[2]);
    final int seed = Integer.parseInt(args[3]);
    final AESEncryptionService aesEncryptionService = new AESEncryptionService();
    aesEncryptionService.executeAESOperation(inputFile, output, mode, seed);
  }

}
