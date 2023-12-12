//package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        list.add(1);
        list.add(2);
        int firstEle = list.get(0);
        assertEquals(1, firstEle);
        int size = list.size();
        assertEquals(2, size);
        List<Integer> listTest = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.addAll(Arrays.asList(3, 4, 5, 6));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), listTest);

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
    public class rangeRemoveSupport<E> extends ArrayList<E> {

        public void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
        }
    }
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<String> list = new ArrayList<>(Arrays.asList("zero", "first", "second", "third", "fourth", "fifth", "sixth"));
        // remove(int index)
        list.remove(2);
        List<String> listTest1 = Arrays.asList("zero", "first", "third", "fourth", "fifth", "sixth");
        assertEquals(listTest1, list);

        // remove(Object o)
        list.remove("zero");
        List<String> listTest2 = Arrays.asList("first", "third", "fourth", "fifth", "sixth");
        assertEquals(listTest2, list);

        // removeRange(int fromIndex, int toIndex)
        rangeRemoveSupport arr = new rangeRemoveSupport();
        arr.add("zero");
        arr.add("first");
        arr.add("second");
        arr.add("third");
        arr.add("forth");
        arr.add("fifth");
        arr.add("sixth");
        arr.removeRange(0, 3);
        List<String> listTest3 = Arrays.asList("third", "forth", "fifth", "sixth");
        assertEquals(listTest3, arr);

        // removeAll(Collection<?> c)
        
        // clear()




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

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {

    }
}
