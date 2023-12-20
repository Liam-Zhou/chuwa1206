import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

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
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.addLast(1);
        list.addFirst(2);
        list.addAll(Arrays.asList(3, 4));
        assertEquals(list.getFirst(), (Integer) 2);
        assertEquals(list.getLast(), (Integer) 4);
        assertEquals(list.get(1), (Integer) 0);
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
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 0, 3, 2, 3, 4, 5, 6));
        list.removeFirst();
        list.removeLast();
        list.remove(0);
        list.removeLastOccurrence(3);
        Collections.sort(list);
        assertEquals(list.getFirst(), (Integer) 2);
    }
}
