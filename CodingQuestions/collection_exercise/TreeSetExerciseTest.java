package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;


/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set= new TreeSet<>();
        set.add(5);
        set.addAll(List.of(1,3,6,2));
        assertTrue(set.contains(1));
        assertFalse(set.contains(100));

        assertEquals(set.first(),Integer.valueOf(1));
        assertEquals(set.last(),Integer.valueOf(6));

        assertEquals(set.subSet(1,100), new TreeSet<>(List.of(1,2,5,3,6)));
        assertTrue(set.subSet(0,1).isEmpty());

        assertEquals(set.headSet(3), new TreeSet<>(List.of(1,2))); //To element is exclusive
        assertEquals(set.tailSet(3), new TreeSet<>(List.of(3,5,6)));

        assertTrue(set.remove(1));
        assertFalse(set.remove(100));

        assertEquals(set.size(), 4);
        assertFalse(set.isEmpty());
    }
}
