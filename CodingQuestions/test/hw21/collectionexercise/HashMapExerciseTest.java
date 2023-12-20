package hw21.collectionexercise;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ethan",0);
        Map temp=new HashMap();
        temp.put("ethan",300);
        map.put("ethan",100);
        map.putIfAbsent("ethan",200);
        map.putAll(temp);
        assert map.get("ethan")==300;
        assert map.getOrDefault("jack",0)==0;
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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ethan",0);
        map.replace("ethan",100);
        map.put("jack",200);
        map.remove("jack");
        map.computeIfAbsent("jack",k->map.get("ethan"));
        assert map.get("jack")==100;
    }
}
