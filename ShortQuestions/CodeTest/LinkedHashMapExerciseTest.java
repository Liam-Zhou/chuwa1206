package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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
        // 创建LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();

        // 添加元素
        map.put("Day1", 10);
        map.put("Day2", 20);

        // putIfAbsent - 只有在键不存在时添加
        map.putIfAbsent("Day3", 30);
        map.putIfAbsent("Day1", 40); // 因为 Day1 已存在，所以这行不会更改任何内容

        // 批量添加元素
        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Day4", 40);
        anotherMap.put("Day5", 50);
        map.putAll(anotherMap);

        // 获取元素
        int day1Value = map.get("Day1");
        System.out.println("Value of Day1: " + day1Value);

        // getOrDefault - 获取元素，如果不存在则返回默认值
        int day6Value = map.getOrDefault("Day6", 0);
        System.out.println("Value of Day6 (default): " + day6Value);

        // 检查键值是否存在
        boolean hasDay2 = map.containsKey("Day2");
        boolean hasValue20 = map.containsValue(20);
        System.out.println("Contains Day2 key: " + hasDay2);
        System.out.println("Contains value 20: " + hasValue20);

        // 获取键集和值集
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        // 检查是否为空
        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty: " + isEmpty);
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
        // 创建LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Day1", 10);
        map.put("Day2", 20);
        map.put("Day3", 30);

        // 替换元素
        map.replace("Day1", 100); // 替换 Day1 的值
        map.replace("Day2", 20, 200); // 只有当 Day2 的当前值为 20 时，才替换为 200

        // 替换所有元素
        map.replaceAll((key, value) -> value + 100); // 所有的值加 100

        // 移除元素
        map.remove("Day3"); // 移除 Day3
        map.remove("Day2", 300); // 只有当 Day2 的值为 300 时才移除（这里不会移除）

        // 计算新值
        map.compute("Day1", (key, value) -> value == null ? 42 : value + 500);
        map.computeIfAbsent("Day4", key -> 400);
        map.computeIfPresent("Day2", (key, value) -> value + 20);

        // 打印最终的映射
        System.out.println("Final map: " + map);
    }
    public static void main(String[] args) {

        LinkedHashMapExerciseTest test = new LinkedHashMapExerciseTest();
        test.learn_Inserting_And_Retrieving();
        test.learn_Remove_Replacing_Updating();

    }
}
