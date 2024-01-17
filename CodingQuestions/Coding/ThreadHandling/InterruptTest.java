package Coding.ThreadHandling;


public class InterruptTest {
    /**
     * @description 仔细看上述代码，main线程通过调用t.interrupt()方法中断t线程，但是要注意，interrupt()方法仅仅向t线程发出了“中断请求”，
     * 至于t线程是否能立刻响应，要看具体代码。而t线程的while循环会检测isInterrupted()，所以上述代码能正确响应interrupt()请求，
     * 使得自身立刻结束运行run()方法。
     */

    public static void main(String[] args) throws InterruptedException {

        Thread t = new MyThreadWithIsInterrupted();
        execute(t);

////        Thread t = new WhileTrue();
////        execute(t);
//
//       Thread t = new SleepForever();
//        execute(t);
    }







    private static void execute(Thread t) throws InterruptedException {
        t.start();
        Thread.sleep(2000); // 暂停2毫秒. Question, who sleep?
        t.interrupt(); // 中断t线程. Question, who is interrupted? 一定会被成功中断么？
        System.out.println("Interrupted!");
        t.join(); // 等待t线程结束. Question, who is running, and who stopped?
        System.out.println("end");
    }
}


class MyThreadWithIsInterrupted extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted?
        // Question, where is isInterrupted() from?
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}

class WhileTrue extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted?
        while (true) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}


class SleepForever extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted?
        try {
            Thread.sleep(5000 * 1000);
        } catch (InterruptedException e) {
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
    }
}