import org.junit.Test;

import java.util.TreeMap;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
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
        TreeMap<String, Integer> map = new TreeMap<>();
        assertTrue(map.isEmpty());
        map.put("apple", 10);
        map.putIfAbsent("apple", 5);
        map.putIfAbsent("banana", 2);
        TreeMap<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("pear", 3);
        anotherMap.put("peach", 4);
        map.putAll(anotherMap);
        assertEquals(map.get("pear"), (Integer) 3);
        assertEquals(map.firstKey(), "apple");
        assertEquals(map.lastKey(), "pear");
        assertTrue(map.containsKey("apple"));
        assertTrue(map.containsValue(3));

        assertTrue(map.keySet().containsAll(Set.of("apple", "banana", "pear", "peach")));
        assertTrue(map.values().containsAll(Set.of(10, 2, 3, 4)));

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

    }
}
