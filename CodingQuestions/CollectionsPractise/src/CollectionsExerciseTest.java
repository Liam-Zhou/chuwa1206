//package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 5, 5);
//        System.out.println(Collections.min(numbers));
        assertEquals(1, Collections.min(numbers).intValue());

        assertEquals(5, Collections.max(numbers).intValue());

        assertEquals(5, Collections.frequency(numbers, 5));

    }

    /**
     * synchronizedList()
     * synchronizedList(List<T> list)
     * Returns a synchronized (thread-safe) list backed by the specified list
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 5, 5);
        List<Integer> syncNumbers = Collections.synchronizedList(numbers);
        assertEquals(5, Collections.frequency(syncNumbers, 5));
    }
}
