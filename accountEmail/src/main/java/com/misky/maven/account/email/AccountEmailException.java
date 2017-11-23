package com.misky.maven.account.email;

import javax.mail.MessagingException;

/**
 * Created by CHILI_USER on 2017/11/20.
 */
public class AccountEmailException extends Exception{
    public AccountEmailException(String message) {
        super(message);
    }

    public AccountEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
