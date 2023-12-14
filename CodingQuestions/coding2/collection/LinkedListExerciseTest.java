package coding2.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(0, 2);
        list.add(list.size() - 1, 9);
        list.addAll(Arrays.asList(2,3,5,6));
        list.addAll(5, Arrays.asList(1,2,36));
        list.get(0);
        list.get(list.size() - 1);
        list.get(2);
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
        List<Integer> list = new LinkedList<Integer>(); // List interface does not have removeFirst and remnove Last
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.addAll(Arrays.asList(1,3,3,5,6,7));
        list.add(0);
        list.remove(0);
        list2.removeFirstOccurrence(1);
        list2.removeLastOccurrence(2);
    }
}
