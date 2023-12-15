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
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        assertEquals(Collections.min(list), Integer.valueOf(0));
        assertEquals(Collections.min(list, Collections.reverseOrder()),Integer.valueOf(1));
        assertEquals(Collections.min(list, (a,b) ->  b - a),Integer.valueOf(1));

        assertEquals(Collections.max(list), Integer.valueOf(1));
        assertEquals(Collections.max(list, Collections.reverseOrder()),Integer.valueOf(0));
        assertEquals(Collections.max(list, (a,b) ->  b - a),Integer.valueOf(0));

        assertEquals(Collections.frequency(list, 0), 1);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {

    }
}
