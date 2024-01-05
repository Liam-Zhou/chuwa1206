package multithreading.Creat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread t = new MyThread();
        t.start();
        System.out.println("*****myThread****");

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("Starting new thread by implementing Runnable with lambda"));
        t3.start();

        Callable<String> callable = new MyCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        Future<String> future = executorService.submit(callable);
        list.add(future);
        Future<String> stringFuture = list.get(0);
        System.out.println(stringFuture);
        System.out.println("************");
        for (int i = 0; i < 5; i++) {
//            Thread.sleep(1000);
            String s = future.get();
            System.out.println(s);
        }

        executorService.shutdown();
    }
}
