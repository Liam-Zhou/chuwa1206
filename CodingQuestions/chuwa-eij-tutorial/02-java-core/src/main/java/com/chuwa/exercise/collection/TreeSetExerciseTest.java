package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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
        TreeSet<Integer> set = new TreeSet<>();

        // Inserting
        set.add(5);
        set.add(3);
        set.addAll(Arrays.asList(1, 4, 6, 8, 2));

        // Retrieving
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());
        System.out.println("Subset from 3 to 6: " + set.subSet(3, 6));
        System.out.println("HeadSet up to 4: " + set.headSet(4));
        System.out.println("TailSet from 5: " + set.tailSet(5));

        // Checking presence
        System.out.println("Contains 4: " + set.contains(4));

        // Removing
        set.remove(6);

        // Size and isEmpty
        System.out.println("Size of set: " + set.size());
        System.out.println("Is set empty: " + set.isEmpty());
    }
}
