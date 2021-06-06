package com.example.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

/**
 * Validator for input.
 */
public class Validator {
    /** Regex constant*/
    private static final String INT_REGEX = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";

    private Validator() {
    }

    /**
     * Checks email format.
     * @param email input
     * @return true if email correct
     */
    public static boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    /**
     * Checks phone format.
     * @param phone input
     * @return true if phone correct
     */
    public static boolean isValidPhone(String phone) {
        return Pattern.compile(EMAIL_REGEX).matcher(phone).matches();
    }

    /**
     * Checks how many years have passed from the entered date to today's date.
     * @param begin enter date
     * @return years have passed
     */
    public static int getTimeLength(String begin) {
        return Period.between(LocalDate.parse(begin), LocalDate.now()).getYears();
    }

    /**
     * Checks number integrity.
     * @param value input
     * @return true if value is int
     */
    public static boolean isValidInt(String value) {
        return Pattern.compile(INT_REGEX).matcher(value).matches();
    }
}
