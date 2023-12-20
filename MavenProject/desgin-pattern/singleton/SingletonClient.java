package com.java.singleton;

public class SingletonClient {
    public static void main(String[] args){
        SingletonEager1 instanceEager1=SingletonEager1.getInstance();
        SingletonEager1 instanceEager1Compare=SingletonEager1.getInstance();

        System.out.println(instanceEager1==instanceEager1Compare);

        SingletonEager2 instanceEager2=SingletonEager2.getInstance();
        SingletonEager2 instanceEager2Compare=SingletonEager2.getInstance();

        System.out.println(instanceEager2==instanceEager2Compare);

        SingletonLazy1 instanceLazy1=SingletonLazy1.getInstance();
        SingletonLazy1 instanceLazy1Compare=SingletonLazy1.getInstance();
        System.out.println(instanceLazy1==instanceLazy1Compare);

        SingletonLazy2 instanceLazy2=SingletonLazy2.getInstance();
        SingletonLazy2 instanceLazy2Compare=SingletonLazy2.getInstance();
        System.out.println(instanceLazy2==instanceLazy2Compare);

        SingletonLazy3 instanceLazy3=SingletonLazy3.getInstance();
        SingletonLazy3 instanceLazy3Compare=SingletonLazy3.getInstance();
        System.out.println(instanceLazy3==instanceLazy3Compare);
    }
}
