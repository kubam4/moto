package com.machi.service;

public class InvalidUserPasswordException extends RuntimeException {

    public InvalidUserPasswordException(final PasswordValidator.Status status) {
    }

}
