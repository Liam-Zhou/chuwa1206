package com.chuwa.tutorial.t06_java8.features.lambda_zhaokuan_chen;

@FunctionalInterface
public interface Foo {
    String aMethod(String str);

    default String defaultBar() {
        String s = "Default Bar Method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "Default Common from Bar";
        System.out.println(s);
        return s;
    }
}
