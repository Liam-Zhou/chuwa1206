package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
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
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.addAll(List.of(1,2,3));
        assertEquals(new HashSet<Integer>(List.of(1,2,3)), set);

        assertTrue(set.contains(2));
        assertFalse(set.contains(4));

        set.remove(1);
        set.remove(1);
        assertEquals(new HashSet<Integer>(List.of(2,3)), set);
        set.clear();
        assertEquals(new HashSet<Integer>(), set);

        assertTrue(set.isEmpty());



    }
}
