package com.waylau.cipher;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.SecureRandom;

public class MsgDigestUtils {

    public static String sha256(String src) {
        return DigestUtils.sha256Hex(src);
    }

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    public static String getSalt() {
        byte[] values = new byte[8];
        SecureRandom random = new SecureRandom();
        random.nextBytes(values);
        Hex hex = new Hex();
        return new String(hex.encode(values));
    }


    public static void main(String[] args) {
        String salt = getSalt();
        System.out.println(salt);
        String password = sha256("123456" + salt);
        System.out.println(password+salt);
    }
}
