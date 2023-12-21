package com.chuwa.exercise.collection;
import java.util.*;
import org.junit.Test;

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
        // 创建 LinkedHashMap 并插入元素
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.putIfAbsent("C", 3);

        // 添加多个元素
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("D", 4);
        anotherMap.put("E", 5);
        map.putAll(anotherMap);

        // 检索元素
        Integer valueA = map.get("A");
        Integer valueF = map.getOrDefault("F", 0);

        // 检查键和值是否存在
        boolean hasB = map.containsKey("B");
        boolean hasValue6 = map.containsValue(6);

        // 获取键集和值集
        System.out.println("键集: " + map.keySet());
        System.out.println("值集: " + map.values());
        System.out.println("Map 是否为空: " + map.isEmpty());
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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        // 替换元素
        map.replace("A", 3);
        map.replace("B", 2, 4);
        map.replaceAll((key, value) -> value + 1);

        // 移除元素
        map.remove("A");

        // 更新元素
        map.compute("C", (key, value) -> (value == null) ? 1 : value + 1);
        map.computeIfAbsent("D", k -> 2);
        map.computeIfPresent("C", (key, value) -> value + 10);

        // 打印最终的 map
        System.out.println("最终的 map: " + map);
    }
}
