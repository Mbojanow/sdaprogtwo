package pl.sdacademy.prog.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import pl.sdacademy.prog.streams.SdaException;

public class AESEncryptionService {

  private final static String ALGORITHM_NAME = "AES";

  private final AESKeyFactory aesKeyFactory;

  public AESEncryptionService(final AESKeyFactory aesKeyFactory) {
    //this.aesKeyFactory = new AESKeyFactory(); - NIE - ZŁO! Łamiemy zasadę soliD - DEPENDENCY INJECTION
    this.aesKeyFactory = aesKeyFactory;
  }

  public void executeAESOperation(final String sourcePath, final String outputPath,
                                  final int operationMode, final int keyGenerationSeed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    final Key key = aesKeyFactory.createAES256BitKey(keyGenerationSeed);
    final Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
    cipher.init(operationMode, key);

    // możemy wykorzystać TRY-WITH-RESOURCES bo BufferedReader implementuj
    // Closeable który rozszerza AutoCloseable
    final byte[] fileInput = readFileContent(sourcePath);
    final byte[] output = cipher.doFinal(fileInput);
    writeContentToFile(outputPath, output);
  }

  private byte[] readFileContent(final String sourcePath) {
    try (FileInputStream fileInputStream = new FileInputStream(new File(sourcePath))) {
      return fileInputStream.readAllBytes();
    } catch (IOException e) {
      throw new SdaException("Could not read input file");
    }
  }

  private void writeContentToFile(final String filePath, final byte[] content) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {
      fileOutputStream.write(content);
    } catch (IOException e) {
      throw new SdaException("Could not save output file");
    }
  }

}
