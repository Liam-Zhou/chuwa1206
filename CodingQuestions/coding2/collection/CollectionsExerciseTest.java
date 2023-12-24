package coding2.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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
        List<Integer> list = Arrays.asList(1,3,3,4,5);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.frequency(list, 3));

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Collections.synchronizedList(list);

    }
}
