package coding2.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set= new TreeSet<>();
        set.add(1);
        set.addAll(Arrays.asList(1,1,1,2,3,4));
        set.contains(1);
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.subSet(1,5));
        System.out.println(set.headSet(10));
        System.out.println(set.tailSet(5));
        set.remove(1);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
