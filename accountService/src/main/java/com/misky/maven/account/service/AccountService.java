package com.misky.maven.account.service;

/**
 * Created by CHILI_USER on 2017/11/27.
 */
public interface AccountService {
    String generateCaptchaKey() throws AccountServiceException;

    byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException;

    void signUp(SignUpRequest signUpRequest) throws AccountServiceException;

    void activate(String activateNumber) throws AccountServiceException;

    void login(String id, String password) throws AccountServiceException;
}
