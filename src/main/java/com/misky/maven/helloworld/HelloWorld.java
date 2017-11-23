package com.misky.maven.helloworld;

/**
 * Created by CHILI_USER on 2017/11/8.
 */
public class HelloWorld {

    public String sayHello(){
        return "Hello Maven";
    }

    public static void main(String [] args){
        System.out.println(new HelloWorld().sayHello());
    }
}
