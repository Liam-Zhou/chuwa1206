import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 *
 * updated kaiyuan
 * 12/13/23
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // 1. Create a new ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 2. Add elements
        list.add("Element1");
        list.add("Element2");

        // 3. Get element
        String firstElement = list.get(0);
        assertEquals("First element should be 'Element1'", "Element1", firstElement);

        // 4. Get Size
        int size = list.size();
        assertEquals("Size of list should be 2 after adding two elements", 2, size);

        // 5. list.addAll(anotherList)
        ArrayList<String> anotherList = new ArrayList<>(Arrays.asList("Element3", "Element4"));
        list.addAll(anotherList);

        // Verify if elements are added and size is updated
        assertEquals("Size should be 4 after adding another list", 4, list.size());
        assertTrue("List should contain all elements of anotherList", list.containsAll(anotherList));
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));

        // remove(int index)
        list.remove(1); // Removes "B"
        // A C D E F
        assertFalse(list.contains("B"));

        // remove(Object o)
        list.remove("C");
        // A D E F
        assertFalse(list.contains("C"));

        // removeRange(int fromIndex, int toIndex) - This is protected in ArrayList, use subList
        list.subList(1, 3).clear(); // Removes "D" and "E"
        // A F
        assertFalse(list.contains("D"));
        assertFalse(list.contains("E"));

        // removeAll(Collection<?> c)
        ArrayList<String> toRemove = new ArrayList<>(Arrays.asList("A", "F"));
        list.removeAll(toRemove);
        assertFalse(list.contains("A"));
        assertFalse(list.contains("F"));

        // clear()
        list.clear();
        assertTrue(list.isEmpty());

        // Repopulate list for update tests
        list.addAll(Arrays.asList("A", "B", "C", "D", "E"));

        // Update: set(int index, E e)
        list.set(2, "Z"); // Replace "C" with "Z"
        // A B Z D E
        assertEquals("Z", list.get(2));

        // Update: replaceAll(UnaryOperator<E> operator)
        UnaryOperator<String> operator = String::toLowerCase;
        // UnaryOperator<String> operator = s -> s.toLowerCase();
        list.replaceAll(operator);
        assertEquals("a", list.get(0));

        // Check: contains(Object o)
        assertTrue(list.contains("a"));

        // Check: indexOf(Object o)
        assertEquals(0, list.indexOf("a"));

        // Check: lastIndexOf(Object o)
        list.add("a"); // Add duplicate
        assertEquals(5, list.lastIndexOf("a"));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        // Obtain an iterator
        Iterator<String> iterator = list.iterator();

        // Check hasNext() and next()
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());

        // Remove an element using remove()
        iterator.remove();
        assertFalse(list.contains("A")); // "A" should be removed from the list

        // Iterate and modify the remaining elements using forEachRemaining()
        Consumer<String> action = s -> list.set(list.indexOf(s), s.toLowerCase());
        iterator.forEachRemaining(action);

        // Validate changes
        assertTrue(list.containsAll(Arrays.asList("b", "c", "d")));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));

        // Using Collections.sort(List<T> list)
        Collections.sort(list);
        assertEquals(Arrays.asList(1, 1, 3, 4, 5, 9), list); // identical in content & order

        // Using List.sort(Comparator<T> c) with Comparator.reverseOrder()
        list.sort(Comparator.reverseOrder());
        assertEquals(Arrays.asList(9, 5, 4, 3, 1, 1), list);
    }
}
