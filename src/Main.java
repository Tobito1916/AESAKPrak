import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;

public class Main {
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        // Schlüssel erzeugen
        SecretKey secretKey = KeyGenerator.getInstance("2b7e151628aed2a6abf7158809cf4f3c").generateKey();

// Verfahren wählen
        Cipher cipher = Cipher.getInstance("AES-128");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

// Umwandlung des Strings nach Bytes basierend auf UTF-8
        byte[] utf8Bytes = "Zu verschlüsselnder String".getBytes("UTF8");

// Verschlüsselung
        byte[] encryptedBytes = cipher.doFinal(utf8Bytes);

// Base64 encoding um wieder einen String zu bekommen
        String encryptedString = java.util.Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println(encryptedString);
    }

}
