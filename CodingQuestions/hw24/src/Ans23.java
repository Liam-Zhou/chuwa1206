import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ans23 {
    private static int i=1;
    private static final Object lock=new Object();
    private static int j=1;
    private static final ReentrantLock lock2=new ReentrantLock();
    private static final Condition cond= lock2.newCondition();

    public static void main(String[] args){
        Solution_Syn_WaitNotify();
        Solution_Reentrant_AwaitSignal();
    }
    public static void Solution_Syn_WaitNotify(){
        class Run1 implements Runnable{
            @Override
            public void run() {
                synchronized (lock) {
                    while(i<=10){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                        i++;
                        lock.notify();
                        try {
                            if(i<=10)
                                lock.wait();
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
        Run1 run1=new Run1();
        Thread t1=new Thread(run1);
        Thread t2=new Thread(run1);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void Solution_Reentrant_AwaitSignal(){

        class Run2 implements Runnable{
            @Override
            public void run(){
                lock2.lock();
                try{
                    while(j<=10){
                        System.out.println(Thread.currentThread().getName()+": "+(j++));
                        cond.signal();
                        if(j<=10)
                            cond.await();
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    lock2.unlock();
                }

            }
        }
        Thread t1=new Thread(new Run2());
        Thread t2=new Thread(new Run2());
        t1.start();
        t2.start();

    }
}
