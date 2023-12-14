package hw21.collectionexercise;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(1);
        assert set.contains(1);
        assert set.size()==1;
    }
}
