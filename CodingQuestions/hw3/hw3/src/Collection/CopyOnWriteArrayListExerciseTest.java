package Collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("Apple");
        list.add("Banana");

        list.add(1, "Avocado");

        list.addAll(Arrays.asList("Cherry", "Date"));
        list.addIfAbsent("Apple");
        list.addIfAbsent("Elderberry");
        List<String> moreFruits = Arrays.asList("Fig", "Grape", "Apple");
        list.addAllAbsent(moreFruits);
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
        while (itr.hasNext()) {
            String fruit = itr.next();
            System.out.println(fruit);

            try {
                itr.remove();
            } catch (UnsupportedOperationException e) {
                System.out.println("Cannot remove item using iterator on a CopyOnWriteArrayList");
            }
        }
        System.out.println("List after iteration: " + list);

    }
}
