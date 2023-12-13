
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

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
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Test add(E e)
        assertTrue(list.add("Apple"));
        assertEquals("Apple", list.get(0));

        // Test add(int index, E element)
        list.add(0, "Banana");
        assertEquals("Banana", list.get(0));

        // Test addAll(Collection c)
        List<String> newFruits = Arrays.asList("Cherry", "Date");
        assertTrue(list.addAll(newFruits));
        assertTrue(list.containsAll(newFruits));

        // Test addIfAbsent(E e)
        assertFalse(list.addIfAbsent("Apple")); // Already present
        assertTrue(list.addIfAbsent("Elderberry")); // Not present

        // Test addAllAbsent(Collection c)
        List<String> moreFruits = Arrays.asList("Fig", "Grape", "Apple"); // Apple already present
        assertEquals(2, list.addAllAbsent(moreFruits)); // Should add only Fig and Grape
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator
        Iterator<String> itr = list.iterator();

        // Test hasNext() and next()
        assertTrue(itr.hasNext());
        assertEquals("Apple", itr.next());
        assertEquals("Banana", itr.next());

        // Remove is not supported in CopyOnWriteArrayList iterator
        try {
            itr.remove();
            fail("Remove operation should throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }
}
