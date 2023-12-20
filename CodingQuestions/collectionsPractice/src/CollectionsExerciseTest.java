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
        List<Integer> list = Arrays.asList(3,1,1,2,4);
        int min = Collections.min(list);
        assertEquals(min, 1);
        int max = Collections.max(list);
        assertEquals(max, 4);
        int freq1 = Collections.frequency(list, 1);
        assertEquals(freq1, 2);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> synclist = Collections.synchronizedList(list);
        assertEquals(synclist.size(), 3);
    }
}
