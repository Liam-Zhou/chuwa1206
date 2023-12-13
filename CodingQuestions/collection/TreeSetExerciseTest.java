import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 * updated kaiyuan
 * 12/13/23
 */

/*
uses a tree for storage
particularly notable for maintaining its elements in a sorted order.
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
        // Initialize TreeSet
        TreeSet<Integer> set = new TreeSet<>();

        // add(E e)
        set.add(3);
        set.add(1);
        assertTrue(set.contains(1));

        // addAll(Collection<> c)
        set.addAll(Arrays.asList(4, 2, 5));
        assertTrue(set.containsAll(Arrays.asList(2, 4, 5)));

        // first() and last()
        assertEquals((Integer) 1, set.first());
        assertEquals((Integer) 5, set.last());

        // subSet(E fromElement, E toElement)
        assertEquals(new TreeSet<>(Arrays.asList(2, 3, 4)), set.subSet(2, true, 5, false));

        // headSet(E toElement)
        assertEquals(new TreeSet<>(Arrays.asList(1, 2)), set.headSet(3, false));

        // tailSet(E fromElement)
        assertEquals(new TreeSet<>(Arrays.asList(3, 4, 5)), set.tailSet(3, true));

        // remove(Object o)
        set.remove(3);
        assertFalse(set.contains(3));

        // size() and isEmpty()
        assertEquals(4, set.size());
        assertFalse(set.isEmpty());
    }
}
