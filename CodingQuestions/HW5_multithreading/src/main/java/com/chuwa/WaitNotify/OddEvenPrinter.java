package com.chuwa.WaitNotify;

public class OddEvenPrinter {
    private final Object obj = new Object();
    private int flag = -1;
    private final int n = 5;

    public void printOdd() throws InterruptedException {
        for(int i = 0; i < n; i++){
            synchronized (obj){
                while(flag != -1){
                    obj.wait();
                }
                System.out.println(i*2 + 1);
                flag = -flag;
                obj.notify();
            }
        }
    }

    public void printEven() throws InterruptedException {
        for(int i = 0; i < n; i++){
            synchronized (obj){
                while(flag != 1){
                    obj.wait();
                }
                System.out.println(i*2 + 2);
                flag = -flag;
                obj.notify();
            }
        }
    }
}
