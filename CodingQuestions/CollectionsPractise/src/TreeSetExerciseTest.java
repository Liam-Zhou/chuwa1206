package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

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
        set.add(1);
        set.add(2);
        set.addAll(new TreeSet<Integer>() {{
            add(3);
            add(4);
        }});
        assertEquals(true, set.contains(1));
        assertEquals(1, set.first().intValue());
        assertEquals(4, set.last().intValue());
        assertEquals(2, set.subSet(1, 3).size());
        assertEquals(1, set.headSet(2).size());
        assertEquals(3, set.tailSet(2).size());
        assertEquals(4, set.size());
        assertEquals(false, set.isEmpty());
    }
}
