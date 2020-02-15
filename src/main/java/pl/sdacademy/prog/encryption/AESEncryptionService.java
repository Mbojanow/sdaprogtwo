package pl.sdacademy.prog.encryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import pl.sdacademy.prog.streams.SdaException;

public class AESEncryptionService {

//  • ścieżka pliku źródłowego
//• ścieżka pliku wyjściowego
//• tryb - 1 - enkrypcja, 2 - dekrypcja
//• seed do generowania losowej liczby

  public void executeAESOperation(final String sourcePath, final String outputPath,
                                  final int operationMode, final int keyGenerationSeed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    final byte[] keyValue = new byte[32];
    new Random(keyGenerationSeed).nextBytes(keyValue);
    final SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
    final Cipher cipher = Cipher.getInstance("AES");
    cipher.init(operationMode, key);

    // możemy wykorzystać TRY-WITH-RESOURCES bo BufferedReader implementuj
    // Closeable który rozszerza AutoCloseable
    final String fileInput;
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourcePath))) {
      fileInput = bufferedReader.lines().collect(Collectors.joining());
    } catch (IOException e) {
      throw new SdaException("Could not read input file");
    }

    final byte[] output = cipher.doFinal(fileInput.getBytes());

    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))) {
      bufferedWriter.write(new String(output));
    } catch (IOException e) {
      throw new SdaException("Could not save output file");
    }
  }


}
