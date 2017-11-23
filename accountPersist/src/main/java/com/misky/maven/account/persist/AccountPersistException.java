package com.misky.maven.account.persist;

/**
 * Created by CHILI_USER on 2017/11/22.
 */
public class AccountPersistException extends Exception {
    public AccountPersistException(String message) {
        super(message);
    }

    public AccountPersistException(String message, Throwable cause) {
        super(message, cause);
    }
}
