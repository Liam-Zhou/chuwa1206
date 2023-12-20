//package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

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
        set.addAll(Set.of(2, 3, 4));
        
        assertEquals(4, set.size());
        assertEquals(true, set.contains(1));
        assertEquals(true, set.containsAll(Set.of(2, 3, 4)));
        set.remove(1);
        assertEquals(3, set.size());
        assertEquals(false, set.isEmpty());
        set.clear();
        assertEquals(true, set.isEmpty());
    }
}
