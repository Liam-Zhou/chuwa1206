import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;


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
        map.put("ID-0", 0);
        assertEquals((Integer) 0, map.get("ID-0"));
        map.putIfAbsent("ID-0", 1);
        assertEquals((Integer) 0, map.get("ID-0"));
        map.putIfAbsent("ID-1", 1);
        assertEquals((Integer) 1, map.get("ID-1"));
        Map<String, Integer> submap = new HashMap<>();
        submap.put("ID-2", 2);
        submap.put("ID-3", 3);
        map.putAll(submap);
        assertEquals((Integer) 2, map.get("ID-2"));
        assertEquals((Integer) 3, map.get("ID-3"));
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
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        DayOfWeek key1 = DayOfWeek.MONDAY;
        DayOfWeek key2 = DayOfWeek.TUESDAY;
        map.put(key1, 1);
        map.put(key2, 2);
        assertEquals((Integer) 1, map.get(key1));
        assertEquals((Integer) 2, map.get(key2));
        map.putIfAbsent(key1, 3);
        assertEquals((Integer) 1, map.get(key1));
        DayOfWeek key3 = DayOfWeek.WEDNESDAY;
        map.putIfAbsent(key3, 3);
        assertEquals((Integer) 3, map.get(key3));
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        Map<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, 1);
        assertEquals((Integer) 1, enumMap.get(DayOfWeek.MONDAY));
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 2);
        assertEquals((Integer) 1, enumMap.get(DayOfWeek.MONDAY));
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
        assertEquals((Integer) 2, enumMap.get(DayOfWeek.TUESDAY));
    }
}
