package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.addLast(3);
        list.addFirst(1);
        list.add(3,4);
        System.out.println(list);

        List<Integer> list2 = Arrays.asList(1,2,3);
        list.addAll(list2);
        System.out.println(list);

        list.addAll(1, list2);
        System.out.println(list);
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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.removeFirst();
        list.removeLast();
        list.remove(0);

        list.add(5);
        list.remove((Integer)5);

        list.add(2);
        list.add(1);
        list.add(2);
        list.removeLastOccurrence(2);

        Collections.sort(list);
    }
}
