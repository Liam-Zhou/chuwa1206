package hw21.collectionexercise;

import org.junit.Test;

import java.util.HashMap;
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
        map.put("ethan",0);
        Map temp=new HashMap();
        temp.put("ethan",300);
        map.put("ethan",100);
        map.putIfAbsent("ethan",200);
        map.putAll(temp);
        assert map.get("ethan")==300;
        assert map.getOrDefault("jack",0)==0;
        map.put("jack",100);
        assert map.firstKey().equals("ethan");
        map.put("apple",300);
        assert map.firstKey().equals("apple");
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
        map.putIfAbsent("ethan",300);
        map.put("jack",100);
        map.put("apple",300);
        map.remove("apple");
        map.replace("ethan",200);
        assert map.get("apple")==null;
        assert map.firstKey().equals("ethan");
        assert map.get("ethan").equals(200);
    }
}
