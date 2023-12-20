package com.chuwa.GenericClass;

public class GenericTest {
    public static void main(String[] args){
        GenericClass<String> s1 = new GenericClass<>("str123");
        System.out.println(s1.getObject());

        GenericClass<Integer> I1 = new GenericClass<>(1);
        System.out.println(I1.getObject().getClass());
    }
 }
