package coding2.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        // Adding elements to the map
        concurrentHashMap.put("One", 1);
        concurrentHashMap.put("Two", 2);
        concurrentHashMap.put("Three", 3);

        // Displaying the initial map
        System.out.println("Initial ConcurrentHashMap: " + concurrentHashMap);

        // Perform operations concurrently
        Runnable readTask = () -> {
            String key = "One";
            System.out.println(Thread.currentThread().getName() + " - Value for " + key + ": " + concurrentHashMap.get(key));
        };

        Runnable writeTask = () -> {
            String key = "Two";
            int newValue = 22;
            concurrentHashMap.put(key, newValue);
            System.out.println(Thread.currentThread().getName() + " - Updated value for " + key + ": " + newValue);
        };

        // Create multiple threads to demonstrate concurrent access
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);
        Thread writerThread = new Thread(writeTask);

        // Start the threads
        readerThread1.start();
        readerThread2.start();
        writerThread.start();

        // Wait for threads to finish
        try {
            readerThread1.join();
            readerThread2.join();
            writerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final map after concurrent operations
        System.out.println("Final ConcurrentHashMap: " + concurrentHashMap);
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        IdentityHashMap<DayOfWeek, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(DayOfWeek.MONDAY, 1);
        identityHashMap.putIfAbsent(DayOfWeek.MONDAY, 2);
        System.out.println(identityHashMap.size()); // 2
        System.out.println(identityHashMap.get(DayOfWeek.MONDAY)); // 1
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.SUNDAY, 7);
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 1);
        System.out.println(enumMap);
    }
}
