import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.*;

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
        assertTrue(map.isEmpty());
        map.put("Apple", 10);
        map.putIfAbsent("Apple", 5);
        assertEquals(map.get("Apple"), (Integer) 10);
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.putIfAbsent("Banana", 2);
        anotherMap.put("Pear", 3);
        map.putAll(anotherMap);
        assertEquals(map.size(), 3);
        assertEquals(map.getOrDefault("Apple", 1), (Integer) 10);
        assertEquals(map.getOrDefault("A", 1), (Integer) 1);
        assertTrue(map.containsKey("Banana"));
        assertTrue(map.containsValue(2));
        Set<String> keys = map.keySet();
        assertTrue(keys.containsAll(Set.of("Apple", "Banana", "Pear")));
        assertTrue(map.values().containsAll(Arrays.asList(10, 2, 3)));
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
        map.putIfAbsent("Banana", 2);
        map.put("Pear", 3);
        map.replace("Banana", 2, 5);
        assertEquals(map.get("Banana"), (Integer) 5);
        map.replace("Banana", 10);
        assertEquals(map.get("Banana"), (Integer) 10);
        BiFunction<String, Integer, Integer> add10 = (a, b) -> b + 10;
        map.replaceAll(add10);
        assertEquals((Integer) 20, map.get("Banana"));

        map.remove("Banana", 10);
        assertTrue(map.containsKey("Banana"));
        map.remove("Banana");
        assertFalse(map.containsKey("Banana"));

        BiFunction<String, Integer, Integer> mapCompute = (key, value) -> value == null ? 0 : value + 5;
        map.computeIfPresent("Banana", mapCompute);
        Function<String, Integer> mapComputeAbsent= (value) -> 10;
        map.computeIfAbsent("Banana", mapComputeAbsent);
        map.compute("Banana", mapCompute);
        assertEquals((Integer) 15, map.get("Banana"));
    }
}
