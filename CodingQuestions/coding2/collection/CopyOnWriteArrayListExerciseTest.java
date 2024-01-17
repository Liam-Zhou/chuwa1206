package coding2.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


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
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//        List list = new CopyOnWriteArrayList();//List does not have addAllAbsent
        // add(E e): Adds the specified element to the end of the list
        list.add("Item 1");

        // add(int index, E element): Adds the specified element at the specified position in the list
        list.add(1, "Item 2");

        // addAll(Collection c): Adds all of the elements in the specified collection to the end of the list
        List<String> anotherList = List.of("Item 3", "Item 4");
        list.addAll(anotherList);

        list.addIfAbsent("Item 1"); // Won't add, as "Item 1" is already present

        List<String> yetAnotherList = List.of("Item 2", "Item 5");
        list.addAllAbsent(yetAnotherList); // Won't add "Item 2", as it is already present

        System.out.println("CopyOnWriteArrayList: " + list);
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
            System.out.println(itr.next());
        }
        list.remove(0);
        System.out.println(list);
    }
}
