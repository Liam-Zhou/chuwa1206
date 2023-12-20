package coding2.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
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
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     * <p>
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     * <p>
     * containsKey(Object key)
     * containsValue(Object value)
     * <p>
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.putIfAbsent("2", 2);
        Map<String, Integer> map2 = new HashMap<>() {
            {
                put("1", 1);
                put("2", 2);
                put("3", 3);
            }
        };
        map.putAll(map2);
        System.out.println(map.get("1"));
        System.out.println(map.getOrDefault("1", -10));
        System.out.println(map.containsValue(2));
        Set<String> set = map.keySet();
       for (int x : map.values()) System.out.println(x);

        System.out.println(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     * <p>
     * remove(Object key)
     * remove(Object key, Object value)
     * <p>
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("1", 1);
                put("2", 2);
                put("3", 3);
            }
        };
        map.replace("1", 5, 100);
        System.out.println(map);
        map.replace("1",100);
        map.replaceAll((k, v) -> v * v);
        System.out.println(map);

    }
}
