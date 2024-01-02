package multithreading.ExecutorFramework;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
public class ThreadPoolExample {
    @Test
    public void fixedThreadPool() {
        // 线程数固定的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

    @Test
    public void cachedThreadPoolExample() {
        // 线程数根据任务动态调整的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

    @Test
    public void singleThreadExecutorExample() {
        // SingleThreadExecutor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

    @Test
    public void scheduledThreadPoolExample() {
        // 创建一个可调度的线程池，核心线程数为 5
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        // 提交一个周期性任务，初始延迟 0 秒(提交之后立即执行)，然后每隔 2 秒执行一次
        executorService.scheduleAtFixedRate(() ->
                System.out.println("Task is running on thread " +
                        Thread.currentThread().getName()), 0, 2, TimeUnit.SECONDS);
    }

    /**
     * 使用ThreadPoolExecutor手动创建线程池可以让您更好地控制线程池的配置
     * 设置了线程池的核心和最大线程数，保持活动时间和时间单位，以及任务队列的容量。
     * 然后，我们将Lambda表达式作为任务提交给线程池来执行。
     * 最后，我们关闭线程池以确保所有任务在应用程序退出之前完成。
     *
     * 通过手动创建线程池，可以更好地控制线程池的参数，
     * 例如核心线程数、最大线程数、保持活动时间、任务队列等。
     * 这使您能够根据应用程序的需求和性能要求进行精细的调整。
     *
     * 具体来说，队列大小决定了在线程池的核心线程都被占用并且队列已满的情况下，新任务的处理方式。有三种基本的情况：
     *
     * 核心线程不足以处理任务： 如果所有核心线程都在执行任务，而队列也满了，此时会创建新的非核心线程来处理任务。
     *
     * 队列未满： 如果队列未满，新的任务会被放入队列中等待执行，直到有线程可用。
     *
     * 队列已满： 如果队列已满，而且线程池的最大线程数也达到上限，此时根据拒绝策略来处理新任务。
     *           默认的拒绝策略是抛出 RejectedExecutionException 异常，但你也可以根据需要自定义拒绝策略。
     */
    @Test
    public void customThreadPoolExample() {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        long keepAliveTime = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        // 任务队列的容量
        int queueCapacity = 100;

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnit,
                new ArrayBlockingQueue<>(queueCapacity)
        );

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

}
