package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        // add()
        set.add(1);
        set.add(2);
        set.add(3);

        // addAll()
        set.addAll(Arrays.asList(4, 5, 6));

        // contains()
        if (set.contains(3)) {
            System.out.println("Set contains 3");
        }

        // remove()
        set.remove(1);

        // clear()
        // set.clear();

        // isEmpty()
        if (!set.isEmpty()) {
            System.out.println("Set is not empty");
        }

        // Iterating over the set
        for (Integer number : set) {
            System.out.println("Set element: " + number);
        }
    }
}
