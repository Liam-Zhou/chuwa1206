import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 * updated kaiyuan
 * 12/13/23
 */
public class CopyOnWriteArrayListExerciseTest {
    /*
    When you modify the list (e.g., add, set, remove elements),
    CopyOnWriteArrayList creates a new copy of the underlying array and applies the modification to this copy.
    Only after the modification is complete does it switch the reference to point to the new, modified array.
    This means that any iteration happening concurrently will be operating on the old, unmodified version of the array.

    iterators work on an unchanging snapshot of the array, read operations (like iterating) don’t require synchronization

    read-heavy scenario
     */

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Initialize CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // add(E e)
        list.add("Apple");
        assertTrue(list.contains("Apple"));

        // add(int index, E element)
        list.add(0, "Banana");
        assertEquals("Banana", list.get(0));

        // addAll(Collection c)
        list.addAll(Arrays.asList("Cherry", "Date"));
        assertTrue(list.containsAll(Arrays.asList("Cherry", "Date")));

        // addIfAbsent(E e)
        // "Apple" is already present, so it should not be added again
        list.addIfAbsent("Apple");
        assertEquals(4, list.size()); // Size should remain the same

        // addAllAbsent(Collection c)
        // Only "Elderberry" is absent, so only it should be added
        list.addAllAbsent(Arrays.asList("Apple", "Elderberry"));
        assertTrue(list.contains("Elderberry"));
        assertEquals(5, list.size()); // Size should increase by 1
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        // Initialize CopyOnWriteArrayList and add elements
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator for the current list snapshot
        Iterator<String> itr = list.iterator();

        // Check hasNext() and next()
        assertTrue(itr.hasNext());
        assertEquals("Apple", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("Banana", itr.next());

        // Attempt to remove an element using the iterator
        try {
            itr.remove();
            fail("Expected UnsupportedOperationException"); // reaching the fail() statement means that the expected failure or exception did not occur as anticipated
        } catch (UnsupportedOperationException e) {
            // Expected exception, as remove() is not supported by CopyOnWriteArrayList's iterator
        }

        // Ensure the list is unchanged
        assertEquals(3, list.size());
    }
}
