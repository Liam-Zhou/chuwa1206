package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9);

        // Test Collections.min without Comparator
        assertEquals(Integer.valueOf(1), Collections.min(list));

        // Test Collections.min with Comparator
        Comparator<Integer> reverseOrder = Comparator.reverseOrder();
        assertEquals(Integer.valueOf(9), Collections.min(list, reverseOrder));

        // Test Collections.max without Comparator
        assertEquals(Integer.valueOf(9), Collections.max(list));

        // Test Collections.max with Comparator
        assertEquals(Integer.valueOf(1), Collections.max(list, reverseOrder));

        // Test Collections.frequency
        assertEquals(2, Collections.frequency(list, 1));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // Synchronizing the ArrayList
        List<Integer> syncList = Collections.synchronizedList(list);

        synchronized(syncList) {
            // Test operations within synchronized block
            syncList.add(3);
            assertEquals(3, syncList.size());
            assertTrue(syncList.contains(3));
        }
    }
}
