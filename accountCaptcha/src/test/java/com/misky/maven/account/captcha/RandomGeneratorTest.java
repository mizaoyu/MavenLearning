package com.misky.maven.account.captcha;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

/**
 * Created by CHILI_USER on 2017/11/23.
 */
public class RandomGeneratorTest {
    @Test
    public void testGetRandomString(){
        Set<String> randoms = new HashSet<String>(100);
        for (int i=0;i<100;i++){
            String random = RandomGenerator.getRandomString();
            assertFalse(randoms.contains(random));
            randoms.add(random);
        }
    }

}
