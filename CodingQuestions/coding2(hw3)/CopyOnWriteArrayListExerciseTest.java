package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

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
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        assertEquals(Character.valueOf('a'), list.get(0));
        List toAdd = new CopyOnWriteArrayList();
        toAdd.add('a');
        toAdd.add('b');
        list.addAll(toAdd);
        assertEquals(Character.valueOf('b'), list.get(4));
        System.out.println(list);
        boolean result = list.addIfAbsent('a');
        System.out.println(list);
        assertFalse(result);
        boolean newResult = list.addIfAbsent(toAdd);
        System.out.println(list);
        assertTrue(newResult);

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
        boolean result = itr.hasNext();
        assertTrue(result);
        assertEquals("Apple", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("Banana", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("Orange", itr.next());
        assertFalse(itr.hasNext());
        list.remove("Orange");
        assertEquals(String.valueOf("Banana"), list.get(1));


    }
}
