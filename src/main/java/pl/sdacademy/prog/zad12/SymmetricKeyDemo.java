package pl.sdacademy.prog.zad12;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SymmetricKeyDemo {

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        final String source = args[0];
        final String target = args[1];
        final int mode = Integer.valueOf(args[2]);
        final long seed = Long.valueOf(args[3]);

        final byte[] data = Files.readAllBytes(Path.of(source));

        AESEncryptionService aesEncryptionService = new AESEncryptionService();
        final byte[] output = aesEncryptionService.executeEncryption(data, mode, seed);

        Files.write(Path.of(target), output, StandardOpenOption.CREATE);
    }
}
