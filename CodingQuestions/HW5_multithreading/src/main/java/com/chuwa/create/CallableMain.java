package com.chuwa.create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exector = Executors.newFixedThreadPool(5);
        List<Future<Boolean>> future = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            future.add(exector.submit(new CallableThread()));
        }
        Thread.sleep(6000);
        for(Future<Boolean> f : future){
            System.out.println(f.get());
        }
        exector.shutdown();
    }
}
