package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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


        assertEquals(Integer.valueOf(1), Collections.min(list));


        Comparator<Integer> reverseOrder = Comparator.reverseOrder();
        assertEquals(Integer.valueOf(9), Collections.min(list, reverseOrder));

        assertEquals(Integer.valueOf(9), Collections.max(list));

        assertEquals(Integer.valueOf(1), Collections.max(list, reverseOrder));

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

        List<Integer> syncList = Collections.synchronizedList(list);

        assertEquals(2, syncList.size());
        assertTrue(syncList.contains(1));
        assertTrue(syncList.contains(2));

    }
}
