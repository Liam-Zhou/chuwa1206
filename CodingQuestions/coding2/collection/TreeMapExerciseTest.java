package coding2.collection;

import org.junit.Test;

import java.util.Set;
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
        map.put("1", 1);
        map.putIfAbsent("1", 1);
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("monday",100);
        map.putAll(map2);

        map.firstEntry();
        map.firstKey();
        map.floorEntry("2");
        map.lowerEntry("2");
        map.containsKey("1");
        map.containsValue(2);
        Set<String> set = map.keySet();
        map.values();
        System.out.println(map2.isEmpty());

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
        map.put("1", 1);
        map.replace("1", 1, 5);
        map.replace("1", 100);
        map.remove("5");
        System.out.println(map);
    }
}
