package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */

/**
 * CopyOnWriteArrayList is the thread safe version of ArrayList
 * */
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
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(0,1);
        list.addAll(List.of(1,2,3));
        ((CopyOnWriteArrayList<Integer>) list).addIfAbsent(3);
        ((CopyOnWriteArrayList<Integer>) list).addIfAbsent(4);
        ((CopyOnWriteArrayList<Integer>) list).addAllAbsent(List.of(1,2,5));
        assertEquals(new CopyOnWriteArrayList<>(List.of(1,1,1,2,3,4,5)), list);
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
        while(itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Orange")) {
//                itr.remove(); cannot be used, not thread-safe?
                list.remove(element);
            }
        }
        assertEquals(new CopyOnWriteArrayList<>(List.of("Apple", "Banana")), list);
    }
}
