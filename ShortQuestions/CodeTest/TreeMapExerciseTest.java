package com.chuwa.exercise.collection;

import org.junit.Test;

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
        // 创建 TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // 添加元素
        map.put("Day1", 10);
        map.put("Day2", 20);
        map.putIfAbsent("Day3", 30);

        // 批量添加元素
        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Day4", 40);
        anotherMap.put("Day5", 50);
        map.putAll(anotherMap);

        // 获取元素
        int day1Value = map.get("Day1");
        String firstKey = map.firstKey();
        String lastKey = map.lastKey();

        // 检查键值是否存在
        boolean hasDay2 = map.containsKey("Day2");
        boolean hasValue20 = map.containsValue(20);

        // 获取键集和值集
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        // 检查是否为空
        boolean isEmpty = map.isEmpty();

        // 打印结果
        System.out.println("Value of Day1: " + day1Value);
        System.out.println("First key: " + firstKey);
        System.out.println("Last key: " + lastKey);
        System.out.println("Contains key Day2: " + hasDay2);
        System.out.println("Contains value 20: " + hasValue20);
        System.out.println("Is map empty: " + isEmpty);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // 创建 TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Day1", 10);
        map.put("Day2", 20);
        map.put("Day3", 30);

        // 替换元素
        map.replace("Day1", 100); // 替换 Day1 的值
        map.replace("Day2", 20, 200); // 只有当 Day2 的当前值为 20 时，才替换为 200

        // 移除元素
        map.remove("Day3"); // 移除 Day3

        // 打印最终的映射
        System.out.println("Final map: " + map);
    }

    public static void main(String[] args) {

        TreeMapExerciseTest test = new TreeMapExerciseTest();
        test.learn_Inserting_And_Retrieving();
        test.learn_Remove_Replacing_Updating();

    }
}
