package com.misky.maven.account.captcha;

/**
 * Created by CHILI_USER on 2017/11/20.
 */
public class AccountCaptchaException extends Exception{
    public AccountCaptchaException(String message) {
        super(message);
    }

    public AccountCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }
}
