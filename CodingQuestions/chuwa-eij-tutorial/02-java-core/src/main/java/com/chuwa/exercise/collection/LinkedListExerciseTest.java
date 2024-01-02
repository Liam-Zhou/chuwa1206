package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<>();

        // Inserting
        list.add(1); // add(E e)
        list.add(2);
        list.addAll(Arrays.asList(3, 4, 5)); // addAll(Collection c)
        list.addAll(3, Arrays.asList(6, 7)); // addAll(int index, Collection c)

        // Retrieving
        System.out.println("First Element: " + list.get(0)); // getFirst()
        System.out.println("Last Element: " + list.get(list.size()-1)); // getLast()
        System.out.println("Element at index 2: " + list.get(2)); // get(int index)
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));

        // Remove
        list.removeFirst();
        list.removeLast();
        list.remove(Integer.valueOf(1)); // remove(Object o) - removes first occurrence of 1
        list.remove(2); // remove(int index) - removes element at index 2
        list.removeLastOccurrence(5); // removeLastOccurrence(Object o)

        // Sort
        Collections.sort(list); // sort()

        System.out.println("Modified and Sorted List: " + list);
    }
}
