package com.machi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String DIGIT_REGEX = "([0-9])";
    private static final String UPPERCASE_REGEX = "([A-Z])";
    private static final String LOWERCASE_REGEX = "([a-z])";
    private static final String SPECIAL_CHARACTER_REGEX = "([_~!@#$%^&*\\-+=`|(){}\\[\\]:;\"'<>,//.//?/\\\\])";
    private static final String UNICODE_CHARACTER_REGEX = "\\W+";
    private static final int MIN_PASSWORD_STRENGTH = 3;

    private static final Pattern DIGIT_PATTERN = Pattern.compile(DIGIT_REGEX);
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(UPPERCASE_REGEX);
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(LOWERCASE_REGEX);
    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile(SPECIAL_CHARACTER_REGEX);
    private static final Pattern UNICODE_PATTERN = Pattern.compile(UNICODE_CHARACTER_REGEX, Pattern.UNICODE_CASE);

    private static final List<Pattern> PATTERNS =
            Arrays.asList(DIGIT_PATTERN, UPPERCASE_PATTERN, LOWERCASE_PATTERN, SPECIAL_CHARACTER_PATTERN, UNICODE_PATTERN);

    private final int minPasswordLength;
    private final PasswordEncoder passwordEncoder;

    public PasswordValidator(final int passwordMinLength, final PasswordEncoder passwordEncoder) {
        this.minPasswordLength = passwordMinLength;
        this.passwordEncoder = passwordEncoder;
    }

    public void validate(final String password1, final String password2) {
//        final Status status = analyzePassword(password1, password2);
//        if (Status.VALID != status) {
//            throw new InvalidUserPasswordException(status);
//        }
    }

    private Status analyzePassword(final String password1, final String password2) {
        if (StringUtils.isEmpty(password1) || StringUtils.isEmpty(password2)) {
            return Status.MISSING_VALUE;
        }

        if (password1.length() < minPasswordLength) {
            return Status.TOO_SHORT;
        }

        if (!password1.equals(password2)) {
            return Status.PASSWORDS_NOT_EQUAL;
        }

        if (calculatePasswordStrength(password1) < MIN_PASSWORD_STRENGTH) {
            return Status.PASSWORD_TOO_WEAK;
        }

        if (containsIllegalCharacter(password1)) {
            return Status.ILLEGAL_CHARACTER;
        }

        return Status.VALID;
    }

    private int calculatePasswordStrength(final String passwordValue) {
        int strength = 0;

        for (Pattern pattern : PATTERNS) {
            strength += find(pattern, passwordValue);
        }

        return strength;
    }

    private boolean containsIllegalCharacter(final String passwordValue) {
        String password = passwordValue;
        for (Pattern pattern : PATTERNS) {
            password = password.replaceAll(pattern.pattern(), "");
        }
        return !password.isEmpty();
    }

    private int find(final Pattern pattern, final String value) {
        int match = 1;
        int notMatch = 0;
        Matcher valueMatcher = pattern.matcher(value);
        return valueMatcher.find() ? match : notMatch;
    }

    public enum Status {
        TOO_SHORT,
        PASSWORDS_NOT_EQUAL,
        PASSWORD_TOO_WEAK,
        ILLEGAL_CHARACTER,
        MISSING_VALUE,
        VALID
    }

}
