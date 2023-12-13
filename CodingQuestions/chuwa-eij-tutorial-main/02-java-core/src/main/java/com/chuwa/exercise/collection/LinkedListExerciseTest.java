import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();

        // Test add(E e) and addLast(E e)
        list.add(1); // Equivalent to list.addLast(1)
        assertEquals(Integer.valueOf(1), list.getLast());

        // Test addFirst(E e)
        list.addFirst(0);
        assertEquals(Integer.valueOf(0), list.getFirst());

        // Test add(int index, E element)
        list.add(1, 10);
        assertEquals(Integer.valueOf(10), list.get(1));

        // Test addAll(Collection c)
        list.addAll(Arrays.asList(2, 3, 4));
        assertEquals(6, list.size());

        // Test addAll(int index, Collection c)
        list.addAll(0, Arrays.asList(-2, -1));
        assertEquals(Integer.valueOf(-2), list.getFirst());

        // Test getFirst(), getLast() and get(int index)
        assertEquals(Integer.valueOf(-2), list.getFirst());
        assertEquals(Integer.valueOf(4), list.getLast());
        assertEquals(Integer.valueOf(10), list.get(1));
    }

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 1, 4, 1, 5));

        // Test removeFirst()
        assertEquals(Integer.valueOf(3), list.removeFirst());

        // Test removeLast()
        assertEquals(Integer.valueOf(5), list.removeLast());

        // Test remove(int index)
        assertEquals(Integer.valueOf(1), list.remove(1)); // Removes the second '1'

        // Test remove(Object o)
        assertTrue(list.remove(Integer.valueOf(4)));

        // Test removeLastOccurrence()
        list.addLast(1);
        assertTrue(list.removeLastOccurrence(1));

        // Test sort()
        list.sort(null); // sorts in natural order
        assertEquals(Arrays.asList(1, 4), list);
    }
}
