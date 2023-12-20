package hw3.CollectionPractice;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

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
        // Creating a new TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // Inserting elements
        map.put("Apple", 3);
        map.putIfAbsent("Banana", 2);
        Map<String, Integer> anotherMap = Map.of("Orange", 5, "Mango", 4);
        map.putAll(anotherMap);

        // Retrieving elements
        System.out.println("Value for key 'Banana': " + map.get("Banana"));
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
        System.out.println("Contains key 'Orange': " + map.containsKey("Orange"));
        System.out.println("Contains value 4: " + map.containsValue(4));
        System.out.println("Key set: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Is map empty? " + map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Creating a new TreeMap
        TreeMap<String, Integer> map = new TreeMap<>(Map.of("Apple", 3, "Banana", 2, "Orange", 5, "Mango", 4));

        // Replacing elements
        map.replace("Banana", 2, 10);
        map.replace("Mango", 15);

        // Removing elements
        map.remove("Apple");

        System.out.println("Map after operations: " + map);
    }
}

