public class RangePrinter {
    public static void main(String[] args) {
        Runnable print1To10 = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread 1: " + i);
            }
        };

        Runnable print11To20 = () -> {
            for (int i = 11; i <= 20; i++) {
                System.out.println("Thread 2: " + i);
            }
        };

        Runnable print21To30 = () -> {
            for (int i = 21; i <= 30; i++) {
                System.out.println("Thread 3: " + i);
            }
        };

        new Thread(print1To10).start();
        new Thread(print11To20).start();
        new Thread(print21To30).start();
    }
}

