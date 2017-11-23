package com.misky.maven.account.captcha;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by CHILI_USER on 2017/11/23.
 */
public class AccountCaptchaServiceTest {
    private AccountCaptchaService service;

    @Before
    public void prepare() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "account-captcha.xml");
        service = (AccountCaptchaService) ctx.getBean("accountCaptchaService");
    }

    @Test
    public void testGenerateCaptcha() throws Exception {
        String captchaKey = service.generateCaptchaKey();
        assertNotNull(captchaKey);

        byte[] captchaImage = service.generateCaptchaImage(captchaKey);
        assertTrue(captchaImage.length > 0);
        //在项目的target目录下创建一个名为主键的jpg格式文件
        File image = new File("target/" + captchaKey + ".jpg");
        OutputStream output = null;
        try {
            //将验证码图片字节数组内容写入到jpg文件中
            output = new FileOutputStream(image);
            output.write(captchaImage);
        } finally {
            if (output != null) {
                output.close();
            }
        }
        //检查文件存在且包含实际内容
        assertTrue(image.exists() && image.length() > 0);
    }

    @Test
    /**
     * 测试验证流程正确性
     * @throws Exception
     */
    public void testValidateCaptchaCorrect() throws Exception {
        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add("12345");
        preDefinedTexts.add("abcde");
        service.setPredefinedTexts(preDefinedTexts);

        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        assertTrue(service.validateCaptcha(captchaKey, "12345"));

        captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        assertTrue(service.validateCaptcha(captchaKey, "abcde"));
    }

    @Test
    /**
     * 测试用户反馈Captcha错误时发生情况
     * @throws Exception
     */
    public void testValidateCaptchaIncorrect() throws Exception {
        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add("12345");
        service.setPredefinedTexts(preDefinedTexts);

        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        assertFalse(service.validateCaptcha(captchaKey, "67890"));
    }
}

