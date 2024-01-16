public class Ans24 {
    private static final Object lock=new Object();
    private static int i=1;
    public static void main(String[] args){
        MyRun run=new MyRun();
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);

        t1.start();
        t2.start();
        t3.start();



    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                int count=0;
                while(count<10){
                    System.out.println(Thread.currentThread().getName()+": "+i++);
                    count++;
                }
            }
        }
    }

}
