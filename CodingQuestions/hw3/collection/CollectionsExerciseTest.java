package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = Arrays.asList(5, 3, 7, 1, 9);

        // Finding minimum element
        int minElement = Collections.min(list);

        // Finding minimum element with a comparator
        Comparator<Integer> reverseOrder = Comparator.reverseOrder();
        int minElementWithComp = Collections.min(list, reverseOrder);

        // Finding maximum element
        int maxElement = Collections.max(list);

        // Finding maximum element with a comparator
        int maxElementWithComp = Collections.max(list, reverseOrder);

        // Frequency of an object
        int frequencyOfOne = Collections.frequency(list, 1);

        // Printing results
        System.out.println("Min element: " + minElement);
        System.out.println("Min element with comparator: " + minElementWithComp);
        System.out.println("Max element: " + maxElement);
        System.out.println("Max element with comparator: " + maxElementWithComp);
        System.out.println("Frequency of 1: " + frequencyOfOne);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Creating a synchronized list
        List<Integer> syncList = Collections.synchronizedList(list);

        // Operations on the synchronized list can be done here
        // For example, adding an element
        syncList.add(6);
        
        // Printing the synchronized list
        synchronized(syncList) {
            for (int element : syncList) {
                System.out.println("Element: " + element);
            }
        }
    }
}
