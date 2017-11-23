package com.misky.maven.helloworld;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by CHILI_USER on 2017/11/8.
 */
public class HelloWorldTest {
    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("Hello Maven", result);
    }
}
