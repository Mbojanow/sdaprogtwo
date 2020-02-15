package pl.sdacademy.prog.encryption;

import pl.sdacademy.prog.streams.SdaException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AESEncryptionService {


  public void executeAESOperation(final String sourcePath, final String outputPath,
                                  final int operationMode, final int keyGenerationSeed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    final byte[] keyValue = new byte[32];
    new Random(keyGenerationSeed).nextBytes(keyValue);
    final SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
    final Cipher cipher = Cipher.getInstance("AES");
    cipher.init(operationMode, key);

    // możemy wykorzystać TRY-WITH-RESOURCES bo BufferedReader implementuj
    // Closeable który rozszerza AutoCloseable
    final byte[] fileInput;
    try (FileInputStream fileInputStream = new FileInputStream(new File(sourcePath))) {
      fileInput = fileInputStream.readAllBytes();
    } catch (IOException e) {
      throw new SdaException("Could not read input file");
    }

    final byte[] output = cipher.doFinal(fileInput);

    try (FileOutputStream fileOutputStream = new FileOutputStream(new File(outputPath))) {
      fileOutputStream.write(output);
    } catch (IOException e) {
      throw new SdaException("Could not save output file");
    }
  }


}
