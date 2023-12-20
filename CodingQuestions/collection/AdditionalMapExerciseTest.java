package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.IdentityHashMap;
import java.util.EnumMap;
import java.util.Map;
import java.time.DayOfWeek;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        ConcurrentHashMap<String,Integer> nameLists=new ConcurrentHashMap<>();
        nameLists.put("Jackson",24);

        nameLists.put("Clara",24);
        nameLists.putIfAbsent("Jackson",26);
        nameLists.putIfAbsent("Jack",23);

        ConcurrentHashMap<String,Integer> anotherNameLists=new ConcurrentHashMap<>();
        anotherNameLists.put("Chris",28);

        nameLists.putAll(anotherNameLists);

        assertEquals(24, nameLists.get("Jackson").intValue());
        assertEquals(24, nameLists.get("Clara").intValue());
        assertEquals(23, nameLists.get("Jack").intValue());
        assertEquals(28, nameLists.get("Chris").intValue());
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

        Map<DayOfWeek,Integer> map=new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY,1);
        map.put(DayOfWeek.FRIDAY,5);
        map.putIfAbsent(DayOfWeek.MONDAY,2);

        assertEquals(1, map.get(DayOfWeek.MONDAY).intValue());
        assertEquals(5, map.get(DayOfWeek.FRIDAY).intValue());


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
        EnumMap<DayOfWeek,Integer> enumMap= new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.TUESDAY,2);
        enumMap.putIfAbsent(DayOfWeek.THURSDAY,4);
        enumMap.putIfAbsent(DayOfWeek.THURSDAY,5);


        assertEquals(2, enumMap.get(DayOfWeek.TUESDAY).intValue());
        assertEquals(4, enumMap.get(DayOfWeek.THURSDAY).intValue());


    }
}
