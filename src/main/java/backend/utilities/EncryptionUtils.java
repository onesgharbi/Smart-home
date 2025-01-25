package backend.utilities;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtils {
    private static final String ALGORITHM = "AES";

    // Generate a new AES key
    public static String generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128); // AES-128 encryption
            SecretKey secretKey = keyGen.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException("Error generating encryption key: " + e.getMessage());
        }
    }

    // Encrypt a string using the given key
    public static String encrypt(String data, String base64Key) {
        try {
            SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(base64Key), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data: " + e.getMessage());
        }
    }

    // Decrypt a string using the given key
    public static String decrypt(String encryptedData, String base64Key) {
        try {
            SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(base64Key), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data: " + e.getMessage());
        }
    }
}


