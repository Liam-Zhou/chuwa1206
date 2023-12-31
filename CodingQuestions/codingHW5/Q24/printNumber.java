package com.chuwa.exercise.t08_multithreading;

public class printNumber implements Runnable{
    private static int current=1;
    private final int start;
    private final int end;
    private static final Object lock = new Object();

    public printNumber(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public void run(){
        synchronized (lock){
            while(current<start){
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            for(int i=start;i<=end;i++){
                System.out.println(Thread.currentThread().getName()+ ": "+ i);
                current++;
                lock.notifyAll();

            }


        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new printNumber(1,10));
        Thread t2=new Thread(new printNumber(11,20));
        Thread t3=new Thread(new printNumber(21,22));

        t1.start();
        t2.start();
        t3.start();

    }
}
