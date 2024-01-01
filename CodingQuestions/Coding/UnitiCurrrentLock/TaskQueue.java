package Coding.UnitiCurrrentLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    Queue<String> q;

    public TaskQueue(){

        this.q = new LinkedList<>();

    }

    public void add(String n){

        lock.lock();

        try{

         q.offer(n);
         condition.signalAll();

        }finally{

            lock.unlock();
        }
    }


    public String getElement() throws InterruptedException{

        lock.lock();
        try {
            while (q.isEmpty()) {
                condition.await();
            }
            return q.remove();
        }
        finally {
            lock.unlock();
        }
    }

    }




