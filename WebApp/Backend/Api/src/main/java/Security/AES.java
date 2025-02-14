package Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class AES {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int IV_SIZE = 12; // GCM benötigt 12-Byte IV
    private static final int TAG_LENGTH = 128;
    private static final int KEY_SIZE = 256;
    private static final int PBKDF2_ITERATIONS = 65536;

    // Beispiel-Schlüsselphrase → Sollte in .env oder Config-Datei gespeichert werden!
    private static final String SECRET_PASSPHRASE = "SehrSicheresPasswort123!";

    // Erzeugt einen AES-Schlüssel aus einer Passphrase
    private static SecretKey getAESKeyFromPassword(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, PBKDF2_ITERATIONS, KEY_SIZE);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    // Verschlüsselt Daten mit AES-GCM
    public static String encrypt(String data) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[IV_SIZE];
        secureRandom.nextBytes(iv);

        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        SecretKey key = getAESKeyFromPassword(SECRET_PASSPHRASE, salt);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(TAG_LENGTH, iv));

        byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

        // Speichere salt + IV + verschlüsselten Key als Base64
        byte[] encryptedPackage = new byte[salt.length + iv.length + encryptedData.length];
        System.arraycopy(salt, 0, encryptedPackage, 0, salt.length);
        System.arraycopy(iv, 0, encryptedPackage, salt.length, iv.length);
        System.arraycopy(encryptedData, 0, encryptedPackage, salt.length + iv.length, encryptedData.length);

        return Base64.getEncoder().encodeToString(encryptedPackage);
    }

    // Entschlüsselt AES-GCM-Daten
    public static String decrypt(String encryptedData) throws Exception {
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);

        byte[] salt = new byte[16];
        byte[] iv = new byte[IV_SIZE];
        byte[] encryptedText = new byte[decodedData.length - salt.length - iv.length];

        System.arraycopy(decodedData, 0, salt, 0, salt.length);
        System.arraycopy(decodedData, salt.length, iv, 0, iv.length);
        System.arraycopy(decodedData, salt.length + iv.length, encryptedText, 0, encryptedText.length);

        SecretKey key = getAESKeyFromPassword(SECRET_PASSPHRASE, salt);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(TAG_LENGTH, iv));

        byte[] decryptedData = cipher.doFinal(encryptedText);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }
}
