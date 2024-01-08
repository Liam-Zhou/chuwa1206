package com.chuwa.ThreeThreads;

public class PrintNumberAnswer {
    private static int value = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(PrintNumberAnswer::run);
        Thread t2 = new Thread(PrintNumberAnswer::run);
        Thread t3 = new Thread(PrintNumberAnswer::run);


        try{
            t3.start();
            t1.start();
            t2.start();

            t3.join();
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(value++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        PrintNumberAnswer.class.notifyAll();
    }

}
