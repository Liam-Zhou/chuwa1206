package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = List.of(1, 2, 3, 3);
        assertEquals(Integer.valueOf(1), Collections.min(list, Integer::compare));
        assertEquals(Integer.valueOf(3), Collections.max(list, Integer::compare));
        assertEquals(2, Collections.frequency(list, 3));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() throws InterruptedException {
        final List<String> list = new ArrayList<>();
        final List<String> synList = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            list.addAll(Arrays.asList("one", "one", "one"));
            synList.addAll(Arrays.asList("one", "one", "one"));
        });

        Thread t2 = new Thread(() -> {
            list.addAll(Arrays.asList("two", "two", "two"));
            synList.addAll(Arrays.asList("two", "two", "two"));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list);
        System.out.println(synList);
    }
}
