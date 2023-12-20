package Collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

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

        map.put("Apple", 50);
        map.put("Banana", 30);

        map.putIfAbsent("Cherry", 20);
        map.putIfAbsent("Apple", 60);

        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Date", 40);
        anotherMap.put("Elderberry", 10);
        map.putAll(anotherMap);

        int applePrice = map.get("Apple");
        System.out.println("Price of Apple: " + applePrice);

        String firstKey = map.firstKey();
        String lastKey = map.lastKey();
        System.out.println("First key: " + firstKey);
        System.out.println("Last key: " + lastKey);

        boolean hasBanana = map.containsKey("Banana");
        System.out.println("Has Banana: " + hasBanana);

        boolean hasPrice20 = map.containsValue(20);
        System.out.println("Has Price 20: " + hasPrice20);

        System.out.println("Keys in map: " + map.keySet());
        System.out.println("Values in map: " + map.values());
        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty: " + isEmpty);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 50);
        map.put("Banana", 30);

        map.replace("Banana", 35);
        map.replace("Cherry", 20, 25);
        map.remove("Apple");

    }
}
