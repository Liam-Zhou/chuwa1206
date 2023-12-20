import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 * updated kaiyuan
 * 12/13/23
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
        LinkedList<Integer> list = new LinkedList<>();

        // Inserting
        list.add(1); // Adds at the end: 1
        list.addFirst(0); // Adds at the beginning: 0 1
        list.add(2, 2); // Adds at index 2: 0 1 2
        list.addAll(Arrays.asList(3, 4)); // Adds a collection at the end: 0 1 2 3 4
        list.addAll(3, Arrays.asList(5, 6)); // Adds a collection at index 3: 0 1 2 5 6 3 4

        // Retrieving
        assertEquals(Arrays.asList(0,1,2,5,6,3,4), list);
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
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape"));


        // removeFirst()
        list.removeFirst();
        assertEquals("Banana", list.getFirst());

        // removeLast()
        list.removeLast();
        assertEquals("Fig", list.getLast());

        // remove(int index)
        list.remove(1); // Removes "Cherry"
        assertFalse(list.contains("Cherry"));

        // remove(Object o)
        list.remove("Fig");
        assertFalse(list.contains("Fig"));

        // Adding "Banana" again to test removeLastOccurrence()
        list.add("Banana");

        // removeLastOccurrence()
        list.removeLastOccurrence("Banana");
        assertEquals(3, list.size() - list.lastIndexOf("Banana"));

        // sort()
        Collections.sort(list);
        assertEquals("Banana", list.getFirst()); // "Banana" should be the first element after sorting
        assertEquals("Elderberry", list.getLast()); // "Elderberry" should be the last element after sorting
    }
}
