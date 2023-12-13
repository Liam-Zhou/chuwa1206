package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 * updated kaiyuan
 * 12/13/23
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
        // Initialize HashSet
        Set<Integer> set = new HashSet<>();

        // add(E e)
        set.add(1);
        assertTrue(set.contains(1));

        // addAll(Collection<> c)
        set.addAll(Arrays.asList(2, 3, 4));
        assertTrue(set.containsAll(Arrays.asList(2, 3, 4)));

        // remove(Object o)
        set.remove(3);
        assertFalse(set.contains(3));

        // clear()
        set.clear();
        assertTrue(set.isEmpty());
    }
}
