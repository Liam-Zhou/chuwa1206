package com.chuwa.exercise.collection;
import org.junit.Test;

import java.util.EnumSet;
import java.util.LinkedHashMap;

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
        // Creating LinkedHashMap of even numbers
        LinkedHashMap<String, Integer> evenNumbers = new LinkedHashMap<>();

        // Using put()
        evenNumbers.put("Two", 2);
        evenNumbers.put("Four", 4);
        System.out.println("Original LinkedHashMap: " + evenNumbers);

        // Using putIfAbsent()
        evenNumbers.putIfAbsent("Six", 6);
        System.out.println("Updated LinkedHashMap(): " + evenNumbers);

        //Creating LinkedHashMap of numbers
        LinkedHashMap<String, Integer> numbers = new LinkedHashMap<>();
        numbers.put("One", 1);

        // Using putAll()
        numbers.putAll(evenNumbers);
        System.out.println("New LinkedHashMap: " + numbers);

        // Using get()
        int value1 = numbers.get("Two");
        System.out.println("Returned Number: " + value1);

        // Using getOrDefault()
        int value2 = numbers.getOrDefault("Five", 5);
        System.out.println("Returned Number: " + value2);

        // Using keySet()
        System.out.println("Keys: " + numbers.keySet());

        // Using values()
        System.out.println("Values: " + numbers.values());

        //Using containsKey() method
        System.out.println("Contains key One? " + numbers.containsKey("One"));

        //Using containsValue() method
        System.out.println("Contains value 6? " + numbers.containsValue(6));

        //Using isEmtpy()
        System.out.println("Is map empty? " + numbers.isEmpty());
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
        LinkedHashMap<String, Integer> numbers = new LinkedHashMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        System.out.println("LinkedHashMap: " + numbers);

        //Using replace()
        numbers.replace("One", 1, 111);
        System.out.println("map after replacing " + numbers);

        //Using replace()
        numbers.replace("Two", 22);
        System.out.println("map after replacing single key value " + numbers);

        //Using replaceAll()
        numbers.replaceAll((k, v) -> v.hashCode());
        System.out.println("map after replacing all " + numbers);

        // remove method with single parameter
        int value = numbers.remove("Two");
        System.out.println("Removed value: " + value);

        // remove method with two parameters
        boolean result = numbers.remove("Three", 3);
        System.out.println("Is the entry Three removed? " + result);

        System.out.println("Updated LinkedHashMap: " + numbers);

        LinkedHashMap<String, Integer> grade = new LinkedHashMap<>();
        grade.put("Math", 50);
        grade.put("Science", 60);
        grade.put("Music", 88);

        //Using compute()
        grade.compute("Math", (k, v) -> v+10);
        System.out.println("grade after computing " + grade);

        //Using computeIfAbsent()
        grade.computeIfAbsent("Ecom", (key) -> {return 80;});
        System.out.println("grade after compute absent " + grade);

        //Using computeIfPresent()
        grade.computeIfPresent("Music", (k, v) -> {return 90;});
        System.out.println("grade after present " + grade);

    }
}
