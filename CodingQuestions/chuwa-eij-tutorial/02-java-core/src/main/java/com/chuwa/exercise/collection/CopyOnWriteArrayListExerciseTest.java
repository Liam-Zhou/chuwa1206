package com.chuwa.exercise.collection;

import org.junit.Test;

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
        CopyOnWriteArrayList<Integer> nums = new CopyOnWriteArrayList<>(List.of(1,2,3,4,5));
        nums.add(6);
        nums.add(0,0);
        nums.addAll(List.of(7,8,9));
        nums.addIfAbsent(1);
        nums.addAllAbsent(List.of(1,2,3,4,10));
        System.out.println(nums);
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
        assertEquals("Apple", itr.next());
        // itr.remove(); will throw UnsupportedOperationException
    }
}
