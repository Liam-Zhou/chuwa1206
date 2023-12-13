package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
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
        set.add(4);
        set.add(1);
        set.add(7);

        List<Integer> list = Arrays.asList(6,9,0);
        set.addAll(list);

        System.out.println(set.contains(0));

        System.out.println(set.first());
        System.out.println(set.last());

        SortedSet<Integer> sortedSet = set.subSet(0, 7);
        System.out.println(sortedSet);

        SortedSet<Integer> headSet = set.headSet(6);
        System.out.println(headSet);

        SortedSet<Integer> tailSet = set.tailSet(1);
        System.out.println(tailSet);

        set.remove(0);
        System.out.println(set);

        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
