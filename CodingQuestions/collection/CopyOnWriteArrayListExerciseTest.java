package com.chuwa.exercise.collection;
import org.junit.Test;

import java.util.ArrayList;
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
        CopyOnWriteArrayList<Integer> ArrLis = new CopyOnWriteArrayList<Integer>();

        // Add elements
        ArrLis.add(2);
        ArrLis.add(3);
        ArrLis.add(4);
        ArrLis.add(7);
        System.out.println("CopyOnWriteArrayList: " + ArrLis);
        System.out.println("On adding 45 it returns "
                + ArrLis.add(45));

        //Using add
        ArrLis.add(0, 2);
        ArrLis.add(0, 3);
        ArrLis.add(1, 4);
        System.out.println("CopyOnWriteArrayList: " + ArrLis);

        //Using addAll
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<Integer>();

        // use add() method to add elements in list2
        list2.add(25);
        list2.add(30);
        list2.add(31);
        list2.add(35);

        ArrLis.addAll(list2);
        System.out.println("add all list: " + ArrLis);

        //Using addIfAbsent()
        ArrLis.addIfAbsent(90);
        System.out.println("add absent: " + ArrLis);

        //Using addallabsent()
        // creating an Empty Integer ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>(4);

        // using add() to initialize values
        arr.add(100);
        arr.add(200);
        arr.add(310);
        arr.add(440);
        System.out.println("\nNumber of elements appended"
                + " using addAllAbsent() method: "
                + ArrLis.addAllAbsent(arr));

        // print CopyOnWriteArrayList
        System.out.println("Modified CopyOnWriteArrayList: "
                + ArrLis);
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

        //Using hasNext()
        System.out.println("has next? " + itr.hasNext());

        //Using next()
        String str = itr.next();
        System.out.println("the next is: " + str);

        //Using remove()
        list.remove("Apple");
        System.out.println("list after removing: " + list);
    }
}
