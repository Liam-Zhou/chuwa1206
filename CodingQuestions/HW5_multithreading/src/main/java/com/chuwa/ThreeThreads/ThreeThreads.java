package com.chuwa.ThreeThreads;

public class ThreeThreads {
    private static final Object firstlock = new Object();
    private static final Object secondlock = new Object();
    private static boolean firstflag = false;
    private static boolean secondflag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new first());
        Thread t2 = new Thread(new second());
        Thread t3 = new Thread(new third());
        t2.start();
        t1.start();
        t3.start();

        try{
            t3.join();
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class first implements Runnable{

        @Override
        public void run() {
            synchronized (firstlock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                firstflag = true;
                firstlock.notify();
            }
        }
    }

    static class second implements Runnable{

        @Override
        public void run() {
            synchronized (firstlock) {
                try {
                    while(!firstflag) firstlock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (secondlock){
                    for(int i = 0; i < 10; i++){
                        System.out.println(i + 10);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    secondflag = true;
                    secondlock.notify();
                }
            }
        }
    }

    static class third implements Runnable{

        @Override
        public void run() {
            synchronized (secondlock) {
                try{
                    while(!secondflag) secondlock.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 20);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
