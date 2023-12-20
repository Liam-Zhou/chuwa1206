import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 * updated kaiyuan
 * 12/13/23
 */

/*
By default, it is the order in which keys were inserted into the map (insertion-order)
Each entry in the LinkedHashMap is maintained in a doubly-linked list.
This linked list defines the iteration ordering
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
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
        // Initialize LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();

        // put(K key, V value)
        map.put("Apple", 10);
        assertEquals((Integer) 10, map.get("Apple"));

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Banana", 20);
        map.putIfAbsent("Apple", 30);
        assertEquals((Integer) 20, map.get("Banana"));
        assertEquals((Integer) 10, map.get("Apple")); // Value for "Apple" remains unchanged

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Cherry", 15);
        anotherMap.put("Date", 25);
        map.putAll(anotherMap);
        assertEquals((Integer) 15, map.get("Cherry"));
        assertEquals((Integer) 25, map.get("Date"));


        // getOrDefault(Object key, V defaultValue)
        assertEquals((Integer) 10, map.getOrDefault("Apple", 0));
        assertEquals((Integer) 0, map.getOrDefault("Elderberry", 0));

        // containsKey(Object key) and containsValue(Object value)
        assertTrue(map.containsKey("Banana"));
        assertTrue(map.containsValue(20));

        // keySet() and values()
        assertTrue(map.keySet().containsAll(Set.of("Apple", "Banana", "Cherry", "Date")));
        assertTrue(map.values().containsAll(Set.of(10, 20, 15, 25)));

        // isEmpty()
        assertFalse(map.isEmpty());

        // Verify order of keys
        List<String> expectedOrder = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        assertEquals(expectedOrder, new ArrayList<>(map.keySet()));
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
        // Initialize LinkedHashMap
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
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
        map.replaceAll((key, value) -> value + 10);
        assertEquals((Integer) 50, map.get("Banana"));

        // remove(Object key)
        map.remove("Apple");
        assertFalse(map.containsKey("Apple"));

        // remove(Object key, Object value)
        map.put("Cherry", 60);
        boolean isRemoved = map.remove("Cherry", 60);
        assertTrue(isRemoved);

        // compute(Key, BiFunction)
        map.compute("Banana", (key, value) -> value == null ? 0 : value + 5);
        assertEquals((Integer) 55, map.get("Banana"));

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("Apple", k -> 60);
        assertEquals((Integer) 60, map.get("Apple"));

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("Apple", (key, value) -> value + 5);
        assertEquals((Integer) 65, map.get("Apple"));
    }
}
