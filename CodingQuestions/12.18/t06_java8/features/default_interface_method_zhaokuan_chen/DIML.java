package com.chuwa.tutorial.t06_java8.features.default_interface_method_zhaokuan_chen;

public interface DIML {

    static final String WORD = "Hello World";

    int add(int a, int b);

    default int subtract(int a, int b) {
        return a - b;
    }

    static String function() {
        return WORD;
    }
}
