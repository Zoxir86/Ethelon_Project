// https://stackoverflow.com/questions/23561104/how-to-encrypt-and-decrypt-string-with-my-passphrase-in-java-pc-not-mobile-plat
package com.dao;

import java.text.SimpleDateFormat;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Utilities {

    protected final static SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");

    protected static String ProtectPassword(String password)
    {
        byte[] encrypted = null;

        try
        {
            String key = "Bar12345Bar12345"; // 128 bit key           //TODO This must not remain hardcoded.
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(password.getBytes());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new String(encrypted);
    }

    protected static String RevealPassword(String password)
    {
        byte[] encrypted = password.getBytes();
        String decrypted = null;

        try
        {
            String key = "Bar12345Bar12345"; // 128 bit key               //TODO This must not remain hardcoded.
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(encrypted));
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return decrypted;
    }
}
