import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 * updated kaiyuan
 * 12/13/23
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        // Initialize TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // put(K key, V value)
        map.put("Apple", 10);
        assertEquals((Integer) 10, map.get("Apple"));

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Banana", 20);
        map.putIfAbsent("Apple", 30);
        assertEquals((Integer) 20, map.get("Banana"));
        assertEquals((Integer) 10, map.get("Apple")); // Value for "Apple" remains unchanged

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Cherry", 15);
        anotherMap.put("Date", 25);
        map.putAll(anotherMap);
        assertEquals((Integer) 15, map.get("Cherry"));
        assertEquals((Integer) 25, map.get("Date"));

        // firstKey() and lastKey()
        assertEquals("Apple", map.firstKey());
        assertEquals("Date", map.lastKey());

        // containsKey(Object key) and containsValue(Object value)
        assertTrue(map.containsKey("Banana"));
        assertTrue(map.containsValue(20));

        // keySet() and values()
        assertTrue(map.keySet().containsAll(Set.of("Apple", "Banana", "Cherry", "Date")));
        assertTrue(map.values().containsAll(Set.of(10, 20, 15, 25)));

        // isEmpty()
        assertFalse(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Initialize the TreeMap
        Map<String, Integer> map = new TreeMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);

        // replace(K key, V oldValue, V newValue)
        boolean isReplaced = map.replace("Apple", 10, 30);
        assertTrue(isReplaced);
        assertEquals((Integer) 30, map.get("Apple"));

        // replace(K key, V value)
        map.replace("Banana", 40);
        assertEquals((Integer) 40, map.get("Banana"));

        // remove(Object key)
        map.remove("Apple");
        assertFalse(map.containsKey("Apple"));
    }
}
