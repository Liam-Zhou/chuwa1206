//package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * A thread-safe variant of ArrayList in which all mutative operations (add, set, and so on)
     * are implemented by making a fresh copy of the underlying array.
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
        list.add("Orange");
        assertEquals("Apple", list.get(0));

        list.add(1, "Pear");
        assertEquals("Pear", list.get(1));
        List<String> add = Arrays.asList("addApple", "addBanana");
        list.addAll(add);
        assertEquals("addApple", list.get(4));

        list.addIfAbsent("addIfAbsent");
        assertEquals("addIfAbsent", list.get(6));

        List<String> addAbsent = Arrays.asList("addApple2", "addBanana");
        list.addAllAbsent(addAbsent);
        assertEquals("addApple2", list.get(7));
        assertEquals(1, Collections.frequency(list, "addBanana"));



    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        // cannot be List<String> list = new CopyOnWriteArrayList<>(); and remove
        // https://stackoverflow.com/questions/28112309/unsupportedoperationexception-when-using-iterator-remove
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            // next执行一次就跑到下一个位置去了
            String element = iterator.next();

            if (element.equals("addApple")) {
                iterator.remove();
            }
        }
//        assertEquals(2, list.size());

    }
}
