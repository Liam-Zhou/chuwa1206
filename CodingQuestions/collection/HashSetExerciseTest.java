package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

import static org.junit.Assert.*;
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

        set.add(1);
        set.add(2);
        assertTrue(set.add(3));
        assertFalse(set.add(2));

        set.addAll(Arrays.asList(4, 5));

        assertTrue(set.contains(3));


        assertTrue(set.remove(3));


        assertFalse(set.isEmpty());


        set.clear();
        assertTrue(set.isEmpty());
    }
}
