package com.chuwa.learn;

public class Main {
    private static String str = "123";

    public static void what() {
        str = "234";
    }

    public static void print() {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Main.print();
        Main.what();
        Main.print();
    }
}