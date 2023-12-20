package hw3.CollectionPractice;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
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
        // Creating a new HashMap
        Map<String, Integer> map = new HashMap<>();

        // Inserting elements
        map.put("Apple", 3); // put(K key, V value)
        map.putIfAbsent("Banana", 2);
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Orange", 5);
        anotherMap.put("Mango", 4);
        map.putAll(anotherMap);

        // Retrieving elements
        System.out.println("Value for key 'Banana': " + map.get("Banana"));
        System.out.println("Value for key 'Grapes' (default): " + map.getOrDefault("Grapes", 0));
        System.out.println("Contains key 'Orange': " + map.containsKey("Orange"));
        System.out.println("Contains value 4: " + map.containsValue(4));
        System.out.println("Key set: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Is map empty? " + map.isEmpty());
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
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Orange", 5);
        map.put("Mango", 4);

        // Replacing elements
        map.replace("Banana", 2, 10);
        map.replace("Mango", 15);
        map.replaceAll((key, value) -> value + 2);

        // Removing elements
        map.remove("Apple");
        map.remove("Orange", 5);

        // Computing elements
        map.compute("Banana", (key, value) -> value * 2);
        map.computeIfAbsent("Grapes", key -> 7);
        map.computeIfPresent("Mango", (key, value) -> value - 5);

        System.out.println("Map after operations: " + map);
    }
}
