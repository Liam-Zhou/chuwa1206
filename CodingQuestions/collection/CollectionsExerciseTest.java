package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,1,2,4,5);
        assertEquals(1, (int)Collections.min(list));
        assertEquals(5, (int)Collections.max(list));

        assertEquals(2,Collections.frequency(list,1));


    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        List<Integer> syncList = Collections.synchronizedList(list);

    }
}
