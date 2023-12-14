import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertTrue(set.isEmpty());
        set.add(1);
        set.addAll(Arrays.asList(2,3,4,5));
        assertTrue(set.contains(4));
        assertEquals(set.first(), (Integer) 1);
        assertEquals(set.last(), (Integer) 5);

        // subSet(E fromElement, E toElement)
        assertEquals(new TreeSet<>(Arrays.asList(2, 3, 4)), set.subSet(2, true, 5, false));
        // headSet(E toElement)
        assertEquals(new TreeSet<>(Arrays.asList(1, 2)), set.headSet(3, false));
        // tailSet(E fromElement)
        assertEquals(new TreeSet<>(Arrays.asList(3, 4, 5)), set.tailSet(3, true));

        set.remove(1);
        assertEquals(set.size(), 4);
    }
}
