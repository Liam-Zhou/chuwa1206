import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 * updated kaiyuan
 * 12/13/23
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
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
        // Initialize HashMap
        Map<String, Integer> map = new HashMap<>();

        // put(K key, V value)
        map.put("Apple", 10);
        assertEquals(Integer.valueOf(10), map.get("Apple"));

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Banana", 20);
        map.putIfAbsent("Apple", 30); // do not modify
        assertEquals((Integer) 20, map.get("Banana"));
        assertEquals((Integer) 10, map.get("Apple")); // Value for "Apple" remains unchanged

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Cherry", 15);
        anotherMap.put("Date", 25);
        map.putAll(anotherMap);
        assertEquals((Integer) 15, map.get("Cherry"));
        assertEquals((Integer) 25, map.get("Date"));


        // getOrDefault(Object key, V defaultValue)
        assertEquals((Integer) 10, map.getOrDefault("Apple", 0));
        assertEquals((Integer) 0, map.getOrDefault("Elderberry", 0));

        // containsKey(Object key)
        assertTrue(map.containsKey("Banana"));

        // containsValue(Object value)
        assertTrue(map.containsValue(20));

        // keySet()
        Set<String> keys = map.keySet();
        assertTrue(keys.containsAll(Set.of("Apple", "Banana", "Cherry", "Date")));

        // values()
        assertTrue(map.values().containsAll(Set.of(10, 20, 15, 25)));

        // isEmpty()
        assertFalse(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Initialize HashMap
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);

        // replace(K key, V oldValue, V newValue)
        boolean isReplaced = map.replace("Apple", 10, 30);
        assertTrue(isReplaced);
        assertEquals((Integer) 30, map.get("Apple"));

        // replace(K key, V value)
        map.replace("Banana", 40);
        assertEquals((Integer) 40, map.get("Banana"));

        // replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        BiFunction<String, Integer, Integer> adder = (a, b) -> b + 10;
        map.replaceAll(adder);
        assertEquals((Integer) 50, map.get("Banana"));

        // remove(Object key)
        map.remove("Apple");
        assertFalse(map.containsKey("Apple"));

        // remove(Object key, Object value)
        map.put("Cherry", 15);
        boolean isRemoved = map.remove("Cherry", 14);
        assertFalse(isRemoved);
        isRemoved = map.remove("Cherry", 15);
        assertTrue(isRemoved);


        // compute(Key, BiFunction)
        BiFunction<String, Integer, Integer> mapper = (key, value) -> value == null ? 0 : value + 5;
        map.compute("Banana", mapper);
        assertEquals((Integer) 55, map.get("Banana"));

        // computeIfAbsent(Key, Function)
        Function<String, Integer> assignmemt= (key) -> 60;
        map.computeIfAbsent("Apple", assignmemt);
        assertEquals((Integer) 60, map.get("Apple"));

        // computeIfPresent(Key, BiFunction)
        BiFunction<String, Integer, Integer> reassignment= (key, value) -> value + 5;
        map.computeIfPresent("Apple", (key, value) -> value + 5);
        assertEquals((Integer) 65, map.get("Apple"));
    }
}
