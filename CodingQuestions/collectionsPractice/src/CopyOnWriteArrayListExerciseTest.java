import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(0, 2);
        assertEquals(list.get(0), (Integer) 2);
        list.addAll(Arrays.asList(3, 4));
        assertEquals(list.size(), 4);
        list.addIfAbsent(1);
        assertEquals(list.size(), 4);
        list.addIfAbsent(0);
        assertEquals(list.size(), 5);
        list.addAllAbsent(Arrays.asList(5, 6));
        assertEquals(list.size(), 7);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), "Apple");
        try {
            itr.remove();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
