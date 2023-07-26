package com.afterlogic.utils;

import java.security.SecureRandom;

public class RandomUtils {
    public static String getRandomString(int len) {

        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
        public static String getRandomMessage() {
            return getRandomString(10);
        }
}

