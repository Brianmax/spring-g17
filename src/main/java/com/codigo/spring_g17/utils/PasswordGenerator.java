package com.codigo.spring_g17.utils;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}<>?";

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generatePassword(
            int length,
            boolean useUppercase,
            boolean useLowercase,
            boolean useNumbers,
            boolean useSpecial) {

        StringBuilder characters = new StringBuilder();

        if (useUppercase) {
            characters.append(UPPERCASE);
        }

        if (useLowercase) {
            characters.append(LOWERCASE);
        }

        if (useNumbers) {
            characters.append(NUMBERS);
        }

        if (useSpecial) {
            characters.append(SPECIAL);
        }

        if (characters.length() == 0) {
            throw new IllegalArgumentException("Debe seleccionar al menos un tipo de carácter.");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

}
