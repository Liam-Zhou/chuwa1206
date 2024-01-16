package com.chuwa.exercise.collection;

import org.junit.Test;

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

        // Adding elements
        set.add(1);
        set.add(2);
        set.add(3);

        // Adding all from a collection
        set.addAll(Arrays.asList(4, 5, 6));

        // Check if the set contains an element
        boolean containsThree = set.contains(3);

        // Removing an element
        set.remove(1);

        // Check if the set is empty
        boolean isEmpty = set.isEmpty();

        // Clearing the set
        set.clear();

        // Printing results
        System.out.println("Contains 3: " + containsThree);
        System.out.println("Is empty after removal: " + isEmpty);
    }
}
