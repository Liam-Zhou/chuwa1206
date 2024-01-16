package multithreading.ConcurrentLocks;
import java.util.concurrent.locks.StampedLock;
/**
 * 乐观锁。读的过程中允许写。
 * 这种使用方式充分利用了StampedLock的乐观读和悲观读的结合，以提高并发性能。
 * 乐观读锁允许快速尝试读取共享数据，而在需要时，可以转换为悲观读锁，以确保读取的一致性
 */
public class StampedLockLearn {
    public static void main(String[] args) {
        Point point = new Point();
        Thread tWrite = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                point.move(100, 200);
            }
            System.out.println("Write Done");
        });

        Thread tRead = new Thread(() -> System.out.println(point.distanceFromOrigin()));

        tWrite.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tRead.start();
    }
}

class Point {
    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)

        // 检查乐观读锁后是否有其他写锁发生
        if (!stampedLock.validate(stamp)) {
            // 获取一个悲观读锁
            stamp = stampedLock.readLock();
            // 读取最终的 x 和 y： 在悲观读锁的保护下，再次读取 x 和 y 的最终值。
            try {
                currentX = x;
                currentY = y;
            } finally {
                // 释放悲观读锁
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
