package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        // 初始化 ConcurrentMap

        System.out.println("--------------- ConcurrentHashMap Test ---------------");

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 添加元素
        map.put("key1", 1);
        map.put("key2", 2);

        // 线程安全的检索和更新
        map.putIfAbsent("key3", 3);

        // 删除元素
        map.remove("key2");

        // 替换元素
        map.replace("key1", 4);

        // 线程安全的遍历
        map.forEach((key, value) -> System.out.println(key + " = " + value));

        // 使用 Lambda 表达式进行复杂操作
        map.computeIfPresent("key3", (key, value) -> value + 1);

        // 再次遍历，查看更改
        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        System.out.println("--------------- IdentityHashMap Test ---------------");

        // 初始化 IdentityHashMap
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();

        // 添加元素
        String key1 = new String("key");
        String key2 = new String("key");
        map.put(key1, 1);
        map.put(key2, 2);

        // 获取元素
        System.out.println("Get key1: " + map.get(key1)); // 输出 1
        System.out.println("Get key2: " + map.get(key2)); // 输出 2

        // 查找元素
        System.out.println("Contains key1? " + map.containsKey(key1)); // 输出 true
        System.out.println("Contains key2? " + map.containsKey(key2)); // 输出 true
        System.out.println("Contains new String(\"key\")? " + map.containsKey(new String("key"))); // 输出 false

        // 删除元素
        map.remove(key1);

        // 遍历映射
        map.forEach((key, value) -> System.out.println(key + " = " + value));

        // 计算大小
        System.out.println("Size of map: " + map.size());
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    @Test
    public void learn_EnumMap() {

        System.out.println("--------------- EnumMap Test ---------------");
        // 初始化 EnumMap
        EnumMap<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);

        // 添加元素
        map.put(DayOfWeek.MONDAY, "Start of the week");
        map.put(DayOfWeek.FRIDAY, "End of the work week");

        // 获取元素
        System.out.println("Monday: " + map.get(DayOfWeek.MONDAY));

        // 删除元素
        map.remove(DayOfWeek.MONDAY);

        // 替换元素
        map.replace(DayOfWeek.FRIDAY, "Casual Friday");

        // 遍历映射
        for (DayOfWeek day : map.keySet()) {
            System.out.println(day + " = " + map.get(day));
        }
        // 计算大小
        System.out.println("Size of map: " + map.size());
    }

    public static void main(String[] args) {

        AdditionalMapExerciseTest test = new AdditionalMapExerciseTest();
        test.learn_ConcurrentHashMap();
        test.learn_IdentityHashMap();
        test.learn_EnumMap();

    }
}
