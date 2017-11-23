package com.misky.maven.account.captcha;

import java.util.List;

/**
 * Created by CHILI_USER on 2017/11/23.
 */
public interface AccountCaptchaService {
    String generateCaptchaKey() throws AccountCaptchaException;

    byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException;

    boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException;

    List<String> getPredefinedTexts();

    void setPredefinedTexts(List<String> predefinedTexts);
}
