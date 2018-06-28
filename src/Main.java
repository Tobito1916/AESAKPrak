import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main {
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        String s1= "";
        String key="2b7e151628aed2a6abf7158809cf4f3c";
        String value="3243f6a8885a308d313198a2e0370734";
        IvParameterSpec iv = new IvParameterSpec(value.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);


        byte[] encrypted = cipher.doFinal(value.getBytes());
       for (int i = 0; i<encrypted.length;i++){
           s1 = s1 + String.format("%8s", Integer.toBinaryString(encrypted[i] & 0xFF)).replace(' ', '0');
        }
        System.out.println(s1);

    }

}
