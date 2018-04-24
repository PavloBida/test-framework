package util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * Created by Pavlo Bida in 2018
 * https://github.com/PavloBida
 */

public class DataGenerator {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String SPECIAL_CHARS = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String USER_PREFIX = "user";
    private static final int PREFERABLE_MIN_LENGTH = 8;

    private static Random random = new Random();

    /**
     * Generates random username.
     * To achieve some proper randomization - preferable minimum length is 10
     * @param length of desired username
     * @return random username
     */
    public static String getRandomUsername(int length) {
        StringBuilder result = new StringBuilder();
        if(length > PREFERABLE_MIN_LENGTH)
            result.append(USER_PREFIX);
        for(int x = 0; x < length; x++) {
            result.append(CHARS.toCharArray()[random.nextInt(CHARS.length())]);
        }
        return result.toString();
    }

    /**
     * Generates random password.
     * @param length of desired password
     * @return random password
     */
    public static String getRandomPassword(int length, boolean includeSpecials) {
        StringBuilder result = new StringBuilder();
        if(includeSpecials) {
            char[] charsPlusSpecials = ArrayUtils.addAll(CHARS.toCharArray(), SPECIAL_CHARS.toCharArray());
            for(int x = 0; x < length; x++) {
                result.append(charsPlusSpecials[random.nextInt(charsPlusSpecials.length)]);
            }
            return result.toString();
        } else {
            return getRandomString(length);
        }
    }

    /**
     * Generates random string.
     * @param length of desired string
     * @return random string
     */
    public static String getRandomString(int length) {
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < length; x++) {
            result.append(CHARS.toCharArray()[random.nextInt(CHARS.length())]);
        }
        return result.toString();
    }
}
