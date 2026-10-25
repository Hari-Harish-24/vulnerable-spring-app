package com.acme.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    // SEEDED-ISSUE: C2 - MD5 is not suitable for password hashing.
    public static String hash(String rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(rawPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
