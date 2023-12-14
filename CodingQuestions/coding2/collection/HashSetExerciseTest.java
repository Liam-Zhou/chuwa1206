package coding2.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     * <p>
     * add(E e)
     * addAll(Collection<> c)
     * <p>
     * get()
     * contains()
     * <p>
     * remove(Object o)
     * clear()
     * <p>
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.addAll(Arrays.asList(1,1, 1, 2,3,4));
        System.out.println(set);
        set.contains(1);
        set.remove(1);
        set.clear();
        System.out.println(set.isEmpty());
    }
}
