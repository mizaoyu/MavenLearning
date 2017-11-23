package com.misky.maven.account.email;

/**
 * Created by CHILI_USER on 2017/11/9.
 */
public interface AccountEmailService {
    void sendMail(String to, String subject, String htmlText) throws AccountEmailException;
}
