package hw3.CollectionPractice;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
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

        // Inserting elements
        list.add(1);
        list.addFirst(0);
        list.add(2);
        list.addAll(List.of(3, 4));
        list.addAll(1, List.of(10, 11));

        // Retrieving elements
        System.out.println("First element: " + ((LinkedList<Integer>) list).getFirst());
        System.out.println("Last element: " + ((LinkedList<Integer>) list).getLast());
        System.out.println("Element at index 2: " + list.get(2));
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
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 2, 5));

        // Removing elements
        list.removeFirst();
        list.removeLast();
        list.remove(2);
        list.remove(Integer.valueOf(3));
        list.removeLastOccurrence(2);

        System.out.println("After removal: " + list);

        // Sorting elements
        list.sort(null); // Natural order sorting
        System.out.println("After sorting: " + list);
    }
}
