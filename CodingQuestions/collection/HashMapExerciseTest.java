package com.chuwa.exercise.collection;
import org.junit.Test;
import org.junit.internal.builders.SuiteMethodBuilder;

import java.util.HashMap;

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
        HashMap<Integer, String> languages = new HashMap<>();

        // add mappings to HashMap
        languages.put(1, "Python");
        languages.put(2, "C");
        languages.put(3, "Java");
        System.out.println("Languages: " + languages);

        // key already not present in HashMap
        languages.putIfAbsent(4, "JavaScript");

        //Using putAll()
        HashMap<Integer, String> sub_map = new HashMap<>();
        sub_map.put(5, "CPP");
        sub_map.put(9, "R");

        languages.putAll(sub_map);
        System.out.println("Updated map " + languages);

        // get the value with key 1
        String value = languages.get(1);
        System.out.println("HashMap Value with Key 1: " + value);

        // mapping for the key is not present in HashMap
        String value2 = languages.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2);

        //Using containsKey()
        System.out.println("contains 5? " + languages.containsKey(5));

        //Using containsValue()
        System.out.println("contains R? " + languages.containsValue("R"));

        //Using keySet()
        System.out.println("Keys: " + languages.keySet());

        //Using value()
        System.out.println("Values: " + languages.values());

        //Using isEmpty()
        System.out.println("is map empty? " + languages.isEmpty());
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
        HashMap<Integer, String> languages = new HashMap<>();

        // add mappings to HashMap
        languages.put(1, "Python");
        languages.put(2, "C");
        languages.put(3, "Java");
        languages.put(5, "Cpp");
        languages.put(9, "package");

        //Using replace()
        languages.replace(1, "Python", "PPon");
        System.out.println("replace after old -> new: " + languages);

        //Using replace()
        languages.replace(2, "CC");
        System.out.println("replace after: " + languages);

        //Using replaceAll()
        languages.replaceAll((k, v) -> v.toUpperCase());
        System.out.println("replace all: " + languages);

        //Using remove()
        languages.remove(5);
        System.out.println("remove key: " + languages);

        //Using remove()
        languages.remove(1, "PPON");
        System.out.println("remove key, value: " + languages);

        HashMap<String, Integer> prices = new HashMap<>();

        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // recompute the value of Shoes with 10% discount
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Updated HashMap: " + prices);

        // compute the value of Shirt
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Updated HashMap: " + prices);

        // recompute the value of Shoes with 10% VAT
        int shoesPrice = prices.computeIfPresent("Shoes", (key, value) -> value + value * 10/100);
        System.out.println("Updated HashMap: " + prices);
    }
}
