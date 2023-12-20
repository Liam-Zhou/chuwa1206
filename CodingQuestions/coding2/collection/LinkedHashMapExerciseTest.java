package coding2.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("1", 1);
        map.putIfAbsent("2", 2);
        map.putAll(map);
        map.get("1");
        System.out.println(map.getOrDefault("1", 9));
        System.out.println(map);

        map.containsKey("-2");
        map.containsValue(2);
        Set<String> set = map.keySet();
        for (int x : map.values()) System.out.println(x);

        map.isEmpty();
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
        // Create a LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Add entries to the map
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        linkedHashMap.put("Three", 3);

        System.out.println("Original LinkedHashMap: " + linkedHashMap);

        linkedHashMap.replace("Two", 2, 22);

        linkedHashMap.replace("Three", 33);

        // replaceAll(BiFunction): Increment each value in the map by 10
        linkedHashMap.replaceAll((key, value) -> value + 10);

        System.out.println("LinkedHashMap after replacements: " + linkedHashMap);

        linkedHashMap.remove("One");

        linkedHashMap.remove("Three", 30);

        System.out.println("LinkedHashMap after removals: " + linkedHashMap);

        linkedHashMap.compute("Two", (key, value) -> value + 5);

        linkedHashMap.computeIfAbsent("Four", key -> 40);

        linkedHashMap.computeIfPresent("Two", (key, value) -> value * value);

        System.out.println("LinkedHashMap after compute operations: " + linkedHashMap);

    }
}
