package Coding;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

   static class Stu implements Callable {
        //2.实现call方法,将此线程需要执行的操作生命call()中
        @Override
        public Object call() throws Exception {
            int sum=0;
            for (int i = 1; i <=100; i++) {
                if(i % 2 == 0){
                    System.out.println(i);
                    sum += i;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {

       Stu stu = new Stu();
        FutureTask futureTask = new FutureTask(stu);
        new Thread(futureTask).start();

        try{

            System.out.println("The Sum is "+ futureTask.get());

        }
        catch (InterruptedException e){

            e.printStackTrace();
        }
        catch (ExecutionException e){

            e.printStackTrace();
        }

    }



}
