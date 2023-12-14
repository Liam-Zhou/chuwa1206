package hw21.collectionexercise;

import org.junit.Test;

import java.util.*;

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
        ArrayList<Integer> list=new ArrayList<>(List.of(1,2,3,4,5));
        assert Collections.min(list, Comparator.naturalOrder())==1;
        assert Collections.max(list, Comparator.reverseOrder())==1;
        assert Collections.frequency(list,5)==1;
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        ArrayList<Integer> list=new ArrayList<>(List.of(1,2,3,4,5));
        List<Integer> sl=Collections.synchronizedList(list);
    }
}
