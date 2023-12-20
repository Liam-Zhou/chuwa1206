package com.chuwa.Lambda;


import com.chuwa.DefaultInterfaceMethod.Base;

public class LambdaTest {
    public static void main(String[] args){
        Base foo = (a ,b) -> a + b;
        System.out.println(foo.add(1,2));
    }

}
