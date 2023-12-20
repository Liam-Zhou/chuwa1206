package collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        map.put("a", 1);
        map.putIfAbsent("b", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("c", 3);
        map2.put("d", 4);
        map.putAll(map2);

        map.get("a");
        map.getOrDefault("e", 5);

        boolean containsG = map.containsKey("g");
        boolean contains2 = map.containsValue(2);

        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        boolean isEmpty = map.isEmpty();
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
        map.put("a", 1);
        map.put("b", 2);

        map.replace("a", 1, 3);
        map.replace("a", 4);

        map.replaceAll((k,v) -> v * v);

        System.out.println(map);

        map.remove("a");
        map.remove("b", 1);

        System.out.println(map);

        map.compute("b", (k,v) -> v+1);

        System.out.println(map);

        map.computeIfAbsent("c", k -> 1);
        System.out.println(map);

        map.computeIfPresent("c", (k,v) -> v*v);
        System.out.println(map);
    }
}
