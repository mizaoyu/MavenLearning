package com.misky.maven.account.service;

/**
 * Created by CHILI_USER on 2017/11/20.
 */
public class AccountServiceException extends Exception{
    public AccountServiceException(String message) {
        super(message);
    }

    public AccountServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
