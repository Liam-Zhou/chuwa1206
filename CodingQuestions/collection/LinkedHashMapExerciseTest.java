package collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
        HashMap<String, Integer> map = new LinkedHashMap<>(5, 0.5f, true);
        map.put("a", 1);
        map.putIfAbsent("b", 2);
        HashMap<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("c", 3);
        map2.put("d", 4);
        map.putAll(map2);

        System.out.println(map);

        map.get("a");
        map.getOrDefault("e", 5);

        System.out.println(map);

        map.containsKey("b");
        map.containsValue(3);

        System.out.println(map);

        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        System.out.println(map.isEmpty());
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        map.replace("a", 2);
        map.replace("a", 2, 3);
        map.replaceAll((k, v) -> v*v);

        System.out.println(map);

        map.remove("a");
        map.remove("b", 1);

        map.compute("b", (k, v) -> v+1);
        System.out.println(map);
        map.computeIfAbsent("c", k -> 1);
        System.out.println(map);
        map.computeIfPresent("b", (k,v) -> v+1);
        System.out.println(map);


    }
}
