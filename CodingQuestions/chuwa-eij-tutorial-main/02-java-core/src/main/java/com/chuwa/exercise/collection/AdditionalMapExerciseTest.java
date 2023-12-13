import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Test put method
        assertNull(map.put("Monday", 1));
        assertEquals(Integer.valueOf(1), map.get("Monday"));

        // Test putIfAbsent
        map.putIfAbsent("Tuesday", 2);
        assertEquals(Integer.valueOf(2), map.get("Tuesday"));
        map.putIfAbsent("Tuesday", 3);
        assertEquals(Integer.valueOf(2), map.get("Tuesday")); // Should not update

        // Test putAll
        ConcurrentHashMap<String, Integer> newMap = new ConcurrentHashMap<>();
        newMap.put("Wednesday", 3);
        newMap.put("Thursday", 4);
        map.putAll(newMap);

        assertEquals(Integer.valueOf(3), map.get("Wednesday"));
        assertEquals(Integer.valueOf(4), map.get("Thursday"));
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<String, Integer> map = new IdentityHashMap<>();

        // Test put method
        assertNull(map.put("Monday", 1)); // Use new String for identity comparison
        assertEquals(Integer.valueOf(1), map.get("Monday"));

        // Test putIfAbsent
        assertNull(map.putIfAbsent("Tuesday", 2));
        assertEquals(Integer.valueOf(2), map.get("Tuesday"));
        map.putIfAbsent("Tuesday", 3);
        assertEquals(Integer.valueOf(2), map.get("Tuesday")); // Should not update

        // IdentityHashMap is not commonly used for general purpose maps.
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }

    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // Test put method
        assertNull(enumMap.put(DayOfWeek.MONDAY, 1));
        assertEquals(Integer.valueOf(1), enumMap.get(DayOfWeek.MONDAY));

        // Test putIfAbsent
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
        assertEquals(Integer.valueOf(2), enumMap.get(DayOfWeek.TUESDAY));
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 3);
        assertEquals(Integer.valueOf(2), enumMap.get(DayOfWeek.TUESDAY)); // Should not update
    }
}
