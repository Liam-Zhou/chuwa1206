package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> numbers = Arrays.asList(4, 2, 7, 1, 5, 3);

        // Finding the minimum element using natural ordering
        int min = Collections.min(numbers);
        System.out.println("Minimum element: " + min);

        // Finding the maximum element using natural ordering
        int max = Collections.max(numbers);
        System.out.println("Maximum element: " + max);

        // Custom comparator for finding the minimum element
        int minWithComparator = Collections.min(numbers, Integer::compare);
        System.out.println("Minimum element with comparator: " + minWithComparator);

        // Custom comparator for finding the maximum element
        int maxWithComparator = Collections.max(numbers, Integer::compare);
        System.out.println("Maximum element with comparator: " + maxWithComparator);

        // Counting the frequency of a specific element
        int frequencyOf5 = Collections.frequency(numbers, 5);
        System.out.println("Frequency of 5: " + frequencyOf5);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
// Creating a regular ArrayList
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Orange");

        // Creating a synchronized version of the ArrayList
        List<String> synchronizedList = Collections.synchronizedList(originalList);

        // Performing operations on the synchronized list in a multi-threaded scenario
        Runnable addTask = () -> {
            synchronizedList.add("Grapes");
            System.out.println("Added Grapes by thread: " + Thread.currentThread().getName());
        };

        Runnable printTask = () -> {
            for (String fruit : synchronizedList) {
                System.out.println("Fruit: " + fruit + " by thread: " + Thread.currentThread().getName());
            }
        };

        // Creating two threads to demonstrate synchronization
        Thread thread1 = new Thread(addTask, "Thread-1");
        Thread thread2 = new Thread(printTask, "Thread-2");

        // Starting the threads
        thread1.start();
        thread2.start();

        // Waiting for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
