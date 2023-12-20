package com.chuwa.exercise.collection;

import org.junit.Test;
import org.junit.Assert;

import javax.swing.*;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            // add element
            list.add(i);
        }
        assertEquals(new ArrayList<>(List.of(0,1,2)), list);
        // get element
        assertEquals(Integer.valueOf(0), list.get(0));

        // get size
        System.out.println(list.size());
        assertEquals(3, list.size());

        // add all
        List<Integer> list2 = new ArrayList<>(List.of(3,4,5,6));
        list.addAll(list2);
        assertEquals(new ArrayList<>(List.of(0,1,2,3,4,5,6)), list);

    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
        System.out.println(list);
        // remove by index
        list.remove(0);
        assertEquals(new ArrayList<>(List.of(2,3,4,5,6)), list);
        // remove by object
        list.remove(Integer.valueOf(3));
        assertEquals(new ArrayList<>(List.of(2,4,5,6)), list);
        // remove by range
        list.subList(0,1).clear();
        assertEquals(new ArrayList<>(List.of(4,5,6)), list);
        // removeAll(Collection<?> c)
        list.removeAll(List.of(6));
        assertEquals(new ArrayList<>(List.of(4,5)), list);
        // clear
        list.clear();
        assertEquals(new ArrayList<>(List.of()), list);

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        List<Character> list = new ArrayList<>(List.<Character>of('A', 'B', 'C'));
        Iterator<Character> iter = list.iterator();
        while(iter.hasNext()) {
            char element = iter.next();
            if (element == 'C') {
                // iterator remove
                iter.remove();
            }
        }
        assertEquals(list, new ArrayList<>(List.<Character>of('A', 'B')));

        // forEachRemaining
        iter = list.iterator();
        iter.forEachRemaining(System.out::println);

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(List.of(4,5,1,3,2));
        // sort 1
        list.sort(null);
        assertEquals(new ArrayList<>(List.of(1,2,3,4,5)), list);
        // sort 2
        Collections.sort(list);
        assertEquals(new ArrayList<>(List.of(1,2,3,4,5)), list);
        // reverse order 1
        Collections.sort(list, Comparator.reverseOrder());
        assertEquals(new ArrayList<>(List.of(5,4,3,2,1)), list);
        // reverse order 2
        list.sort(Comparator.reverseOrder());
        assertEquals(new ArrayList<>(List.of(5,4,3,2,1)), list);

    }
}
