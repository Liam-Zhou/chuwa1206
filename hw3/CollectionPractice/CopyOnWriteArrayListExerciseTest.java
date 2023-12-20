package hw3.CollectionPractice;
import org.junit.Test;

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
        // Creating a new CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Inserting elements
        list.add("Apple");
        list.add(1, "Banana");
        list.addAll(List.of("Orange", "Mango"));
        list.addIfAbsent("Apple");
        list.addAllAbsent(List.of("Banana", "Grapes"));

        // Retrieving elements
        System.out.println("List after inserting: " + list);
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

        // Creating an iterator
        Iterator<String> iterator = list.iterator();

        // Iterating and removing elements using the iterator
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Iterator: " + fruit);

            if (fruit.equals("Banana")) {
                iterator.remove();
            }
        }

        System.out.println("List after iterator removal: " + list);
    }
}
