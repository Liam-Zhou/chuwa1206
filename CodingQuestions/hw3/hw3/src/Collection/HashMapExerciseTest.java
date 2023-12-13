package Collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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
        Map<String, Integer> map = new HashMap<>();

        map.put("Apple", 50);
        map.put("Banana", 30);

        map.putIfAbsent("Cherry", 20);
        map.putIfAbsent("Apple", 60);

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Date", 40);
        anotherMap.put("Elderberry", 10);
        map.putAll(anotherMap);

        int applePrice = map.get("Apple");
        System.out.println("Price of Apple: " + applePrice);

        int figPrice = map.getOrDefault("Fig", 0);
        System.out.println("Price of Fig: " + figPrice);

        System.out.println("Has Banana: " + map.containsKey("Banana"));

        System.out.println("Has Price 20: " + map.containsValue(20));
        System.out.println("Keys in map: " + map.keySet());
        System.out.println("Values in map: " + map.values());
        System.out.println("Is map empty: " + map.isEmpty());
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
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);
        map.replace("Banana", 35);
        map.replaceAll((key, value) -> value + 5);
        System.out.println("Map after replaceAll: " + map);
        map.remove("Apple");
        map.compute("Date", (key, value) -> (value == null) ? 40 : value + 5);
        Function<String, Integer> computeFunction = key -> 42;
        map.computeIfAbsent("Elderberry", computeFunction);
        BiFunction<String, Integer, Integer> computeIfPresentFunction = (key, value) -> value + 2;
        map.computeIfPresent("Cherry", computeIfPresentFunction);
    }
}
