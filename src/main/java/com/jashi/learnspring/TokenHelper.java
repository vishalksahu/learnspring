package com.jashi.learnspring;

import java.util.Base64;

public class TokenHelper {

    public static String obtainToken(String intermediateKey) {
        return Base64.getEncoder().encodeToString(intermediateKey.getBytes());
    }

    public static String mixUpKey(String key) {
        StringBuilder stringBuilder = new StringBuilder(key);
        StringBuilder reversedKey = stringBuilder.reverse();
        return reversedKey.append(key.length()).toString();
    }
}
