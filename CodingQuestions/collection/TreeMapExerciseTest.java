package collection;

import org.junit.Test;

import java.util.*;

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
        map.put("a", 1);
        map.putIfAbsent("b", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("c", 3);
        map2.put("d", 4);
        map.putAll(map2);

        map.get("a");
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        boolean containsG = map.containsKey("g");
        boolean contains2 = map.containsValue(2);

        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        boolean isEmpty = map.isEmpty();
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
        map.put("a", 1);
        map.put("b", 2);

        map.replace("a", 1, 2);
        map.replace("b", 3);

        map.remove("b");
    }
}
