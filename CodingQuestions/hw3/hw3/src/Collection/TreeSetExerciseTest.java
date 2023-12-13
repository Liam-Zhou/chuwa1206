package Collection;

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
        TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(5);
        set.add(15);

        set.addAll(Arrays.asList(20, 25, 30));
        boolean hasTen = set.contains(10);
        System.out.println("Set contains 10: " + hasTen);

        int firstElement = set.first();
        int lastElement = set.last();

        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);

        Set<Integer> subSet = set.subSet(10, 25);
        System.out.println("Subset (10 inclusive, 25 exclusive): " + subSet);

        Set<Integer> headSet = set.headSet(20);
        System.out.println("HeadSet (up to 20 exclusive): " + headSet);

        Set<Integer> tailSet = set.tailSet(15);
        System.out.println("TailSet (15 inclusive and above): " + tailSet);
        set.remove(10);
        int size = set.size();
        System.out.println("Size of set: " + size);

        boolean isEmpty = set.isEmpty();
        System.out.println("Is set empty: " + isEmpty);

    }
}
