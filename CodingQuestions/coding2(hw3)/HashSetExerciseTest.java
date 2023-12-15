package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        System.out.println(set);
        HashSet<Character> set2 = new HashSet<>();
        set2.add('a');
        set2.add('b');
        set2.add('c');
        set.addAll(set2);
        System.out.println(set);
        assertTrue(set.contains('a'));
        set.remove('a');
        assertFalse(set.contains('a'));
        set.clear();
        System.out.println(set);
        assertTrue(set.isEmpty());
    }
}
