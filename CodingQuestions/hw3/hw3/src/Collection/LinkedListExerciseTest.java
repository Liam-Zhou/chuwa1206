package Collection;

import org.junit.Test;

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
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.addFirst(5);
        list.add(20);

        list.add(1, 15);

        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(1);
        list.addAll(anotherList);


        System.out.println("LinkedList after insertions: " + list);
        int firstElement = list.getFirst();
        int lastElement = list.getLast();
        int elementAtIndex = list.get(2);
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
        System.out.println("Element at index 2: " + elementAtIndex);
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
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(15);
        list.add(20);

        System.out.println("Original LinkedList: " + list);
        list.removeFirst();
        list.removeLast();
        list.remove(1);
        list.remove(Integer.valueOf(10));
        list.removeLastOccurrence(Integer.valueOf(20));
        System.out.println("LinkedList after removals: " + list);
    }
}
