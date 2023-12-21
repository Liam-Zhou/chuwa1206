package com.chuwa.exercise.collection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.time.DayOfWeek;
import org.junit.Test;

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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.putIfAbsent("B", 2);

        // 创建另一个 map 并添加元素
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("C", 3);
        anotherMap.put("D", 4);

        // 使用 putAll 方法
        map.putAll(anotherMap);

        // 打印最终的 map
        System.out.println("ConcurrentHashMap: " + map);

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
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
        map.put("A", 1);
        map.putIfAbsent("B", 2);

        // 打印最终的 map
        System.out.println("IdentityHashMap: " + map);
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);

        // 打印最终的 enumMap
        System.out.println("EnumMap: " + enumMap);
    }
}
