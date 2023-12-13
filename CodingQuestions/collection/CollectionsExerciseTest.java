package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 * updated kaiyuan
 * 12/13/23
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

        // Collections.min without Comparator
        int min = Collections.min(list);
        assertEquals(1, min);

        // Collections.min with Comparator
        int minWithComp = Collections.min(list, Comparator.reverseOrder());
        assertEquals(9, minWithComp);

        // Collections.max without Comparator
        int max = Collections.max(list);
        assertEquals(9, max);

        // Collections.max with Comparator
        int maxWithComp = Collections.max(list, Comparator.reverseOrder());
        assertEquals(1, maxWithComp);

        // Collections.frequency
        int freq = Collections.frequency(list, 1);
        assertEquals(2, freq);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // Create a standard ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        // Wrap it in a synchronized list
        List<Integer> syncList = Collections.synchronizedList(arrayList);

        // Operations on the synchronized list
        syncList.add(3);
        assertEquals(3, syncList.size());

        // individual operations on a synchronized list are thread-safe
        // iteration over a synchronized collection is not automatically thread-safe.
        // Synchronization is required for iteration
        // current thread holds the lock on syncList for the duration of the iteration.
        synchronized (syncList) {
            for (int num : syncList) {
                assertTrue(syncList.contains(num));
            }
        }
    }
}
