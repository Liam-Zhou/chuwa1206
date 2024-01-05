package hw5;

import java.util.concurrent.*;

public class ThreadsCreation {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("new threads");
        }
    }

    public static class MyRunnable implements  Runnable {
        @Override
        public void run() {
            System.out.println("Start new thread");
        }
    }

    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(4000);
            return "Start new thread";
        }
    }
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        Thread t2 = new Thread(new MyRunnable());
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        MyCallable myCallable = new MyCallable();
        try {
            Future<String> futureResult = executorService.submit(myCallable);
            String result  = futureResult.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
