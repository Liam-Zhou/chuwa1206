package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<>();

        // Inserting elements
        list.add(1); // Add at the end
        list.addFirst(0); // Add at the beginning
        list.add(2, 2); // Add at specific index
        list.addAll(Arrays.asList(3, 4, 5)); // Add a collection
        list.addAll(0, Arrays.asList(-2, -1)); // Add a collection at specific index

        // Retrieving elements
        int firstElement = list.getFirst();
        int lastElement = list.getLast();
        int specificElement = list.get(2);

        // Printing results
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        System.out.println("Element at index 2: " + specificElement);
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));

        // Removing elements
        list.removeFirst();
        list.removeLast();
        list.remove(new Integer(1)); // Remove first occurrence of 1
        list.removeLastOccurrence(new Integer(1)); // Remove last occurrence of 1
        list.remove(2); // Remove element at index 2

        // Sorting the list
        list.sort(Comparator.naturalOrder());

        // Printing the sorted list
        list.forEach(System.out::println);
    }
}
