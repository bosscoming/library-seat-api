package com.wydxda.seat.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

public class AESUtils {

    private static final String sessionKey = "u4dkoXGbcTrV6c1j";
    // 偏移量 16位
    private static final String iv = "u4dkoXGbcTrV6c1j";
    private static Key key;
    private static Cipher cipher;
    private final static String KEY_ALGORITHM = "AES";
    // 加解密算法/模式/填充方式
    private final static String algorithmStr = "AES/CBC/PKCS7Padding";
    private static byte[] ivByte;


    public static void init() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        // 算法名称
        byte[] keybytes = sessionKey.getBytes();
        ivByte = iv.getBytes();

        // 加解密 密钥 16位
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
//        int base = 16;
//        if (keybytes.length % base != 0) {
//            int groups = keybytes.length / base + (keybytes.length % base != 0 ? 1 : 0);
//            byte[] temp = new byte[groups * base];
//            Arrays.fill(temp, (byte) 0);
//            System.arraycopy(keybytes, 0, temp, 0, keybytes.length);
//            keybytes = temp;
//        }

        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keybytes, KEY_ALGORITHM);
        cipher = Cipher.getInstance(algorithmStr, "BC");
    }

    /**
     * 加密方法
     *
     * @param content
     *            要加密的字符串
     *            加密密钥
     * @return
     */
    public static String encrypt(String content) {
        byte[] encryptedText = null;
        byte[] contentByte = content.getBytes();
        try {
            init();
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ivByte));
            encryptedText = cipher.doFinal(contentByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new String(Hex.encode(encryptedText));
    }
    /**
     * 解密方法
     *
     * @param encryptedData
     *            要解密的字符串
     *            解密密钥
     * @return
     */
    public static String decrypt(String encryptedData) {
        byte[] encryptedText = null;
        byte[] encryptedDataByte = Hex.decode(encryptedData);
        try {
//            init();
//            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivByte));
            encryptedText = cipher.doFinal(encryptedDataByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new String(encryptedText);
    }
}
