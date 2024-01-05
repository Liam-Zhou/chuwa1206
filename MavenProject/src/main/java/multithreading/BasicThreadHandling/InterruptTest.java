package multithreading.BasicThreadHandling;
import org.junit.Test;
/**
 * 中断线程就是其他线程给该线程发一个信号，该线程收到信号后结束执行run()方法，使得自身线程能立刻结束运行。
 */
public class InterruptTest {
    /**
     * 仔细看上述代码，main线程通过调用t.interrupt()方法中断t线程，但是要注意，interrupt()方法仅仅向t线程发出了“中断请求”，
     * 至于t线程是否能立刻响应，要看具体代码。而t线程的while循环会检测isInterrupted()，所以上述代码能正确响应interrupt()请求，
     * 使得自身立刻结束运行run()方法。
     */

    @Test
    public void testIsInterrupted() throws InterruptedException {
        Thread t = new MyThreadWithIsInterrupted();
        execute(t);

    }

    @Test
    public void testInterruptWhileTrue() throws InterruptedException {
        Thread t = new WhileTrue();
        execute(t);
    }

    @Test
    public void testInterruptSleep() throws InterruptedException {
        Thread t = new SleepForever();
        execute(t);
    }

    private void execute(Thread t) throws InterruptedException {
        t.start();
        // 暂停2毫秒. Question, who sleep?
            // The main thread (the thread that is executing the execute method) sleeps for 2000 milliseconds (2 seconds).
            // During this time, the newly started thread t is running concurrently.
        Thread.sleep(2000);
        // 中断t线程. Question, who is interrupted? 一定会被成功中断么?
            // Thread t是如何设计的来决定是否会被中断。如果t检查Thread.interrupted() or by catching InterruptedException
            // 那么t会被中断，否则可能会继续执行
        t.interrupt();
        // 等待t线程结束. Question, who is running, and who stopped?
            // execute被Block，要等待t执行完成或被Interrupt之后才会继续执行
        t.join();
        System.out.println("end");
    }
}


class MyThreadWithIsInterrupted extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted?
            // yes
        // Question, where is isInterrupted() from?
            // from test method testIsInterrupted() -> execute()
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
            // no
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
            // yes, because of the exception
        try {
            Thread.sleep(5000 * 1000);
        } catch (InterruptedException e) {
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
    }
}