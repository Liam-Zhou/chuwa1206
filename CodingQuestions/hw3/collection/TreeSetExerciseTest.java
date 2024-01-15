package com.chuwa.exercise.collection;

import org.junit.Test;

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
        Set<Integer> set = new TreeSet<>();

        // Adding elements
        set.add(3);
        set.add(1);
        set.add(4);

        // Adding all from a collection
        set.addAll(Arrays.asList(2, 5, 6));

        // Checking for elements
        boolean containsFour = set.contains(4);

        // Getting first and last elements
        int firstElement = ((TreeSet<Integer>) set).first();
        int lastElement = ((TreeSet<Integer>) set).last();

        // Subsets
        Set<Integer> subSet = ((TreeSet<Integer>) set).subSet(2, 5);
        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(3); // Elements less than 3
        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(4); // Elements greater than or equal to 4

        // Removing an element
        set.remove(1);

        // Checking size and if empty
        int size = set.size();
        boolean isEmpty = set.isEmpty();

        // Printing results
        System.out.println("Contains 4: " + containsFour);
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        System.out.println("SubSet (2,5): " + subSet);
        System.out.println("HeadSet (3): " + headSet);
        System.out.println("TailSet (4): " + tailSet);
        System.out.println("Size: " + size);
        System.out.println("Is empty: " + isEmpty);
    }
}
