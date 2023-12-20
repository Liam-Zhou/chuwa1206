import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        int min = Collections.min(list);
        int max = Collections.max(list);
        int fre = Collections.frequency(list, 0);
        System.out.println(min + " " + max + " " + fre);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = Arrays.asList(0, 1, 2);
        List<Integer> list2 = Collections.synchronizedList(list);
    }
}
