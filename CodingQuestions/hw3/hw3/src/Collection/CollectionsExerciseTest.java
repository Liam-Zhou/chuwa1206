package Collection;

import org.junit.Test;

import java.util.ArrayList;
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
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);

        // Finding minimum and maximum without a Comparator (natural ordering)
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        int freq = Collections.frequency(numbers, 1);

        System.out.println(min);
        System.out.println(max);
        System.out.println(freq);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        List<String> syncList = Collections.synchronizedList(list);
    }
}
