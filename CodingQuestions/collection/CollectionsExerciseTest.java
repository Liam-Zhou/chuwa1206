package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
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
        List<Integer> numbers = Arrays.asList(10, 12, 9, 9, 0);
        assertEquals(12, (int)Collections.max(numbers));
        assertEquals(0, (int)Collections.min(numbers));
        assertEquals(2, (int)Collections.frequency(numbers, 9));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5));
        List<Integer> syncList = Collections.synchronizedList(numbers);
    }
}
