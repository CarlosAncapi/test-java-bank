package org.example.pruebabanco.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationUtil {

    public static boolean verifyFormatEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean verifyPasswordSecurity(String password) {
        if (password.length() < 5) {
            return false;
        }
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
        }
        return upperCount >= 1 && lowerCount >= 2 && digitCount >= 2;
    }


}
