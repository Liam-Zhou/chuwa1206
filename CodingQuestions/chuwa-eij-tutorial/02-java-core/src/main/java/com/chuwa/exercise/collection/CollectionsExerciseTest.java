package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<String> list = new ArrayList<>(Arrays.asList("apple", "orange", "banana", "cherry"));

        // Collections.min() - Find the minimum element
        String minElement = Collections.min(list);
        System.out.println("Minimum element: " + minElement);

        // Collections.min() with Comparator - Find the minimum element based on length
        String minLengthElement = Collections.min(list, Comparator.comparingInt(String::length));
        System.out.println("Minimum length element: " + minLengthElement);

        // Collections.max() - Find the maximum element
        String maxElement = Collections.max(list);
        System.out.println("Maximum element: " + maxElement);

        // Collections.max() with Comparator - Find the maximum element based on length
        String maxLengthElement = Collections.max(list, Comparator.comparingInt(String::length));
        System.out.println("Maximum length element: " + maxLengthElement);

        // Collections.frequency() - Count the frequency of an element
        int frequency = Collections.frequency(list, "apple");
        System.out.println("Frequency of 'apple': " + frequency);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // Creating a normal ArrayList
        List<String> list = new ArrayList<>(Arrays.asList("apple", "orange", "banana", "cherry"));

        // Converting it to a synchronized (thread-safe) list
        List<String> synchronizedList = Collections.synchronizedList(list);

        System.out.println("Synchronized list: " + synchronizedList);
    }
}
