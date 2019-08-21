package pl.sdacademy.prog.zad12;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AESEncryptionService {

    private static final String ALGORITHM = "AES";
    private static final int AES_KEY_LEN = 32;

    public byte[] executeEncryption(final byte[] data, final int mode, final long seed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        final Random random = new Random(seed);
        final byte[] key = new byte[AES_KEY_LEN];
        random.nextBytes(key);
        final SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        final Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(mode, secretKey);
        return cipher.doFinal(data);
    }
}
