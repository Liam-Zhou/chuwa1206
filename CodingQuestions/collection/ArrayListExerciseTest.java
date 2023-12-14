package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.UnaryOperator;
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
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> anotherList=new ArrayList<>();
        anotherList.add(3);
        anotherList.add(4);
        list.addAll(anotherList);

        assertEquals(4, list.size());
        assertEquals(3,list.get(2));

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
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        assertEquals(0, list.indexOf(1));
        assertEquals(3,list.lastIndexOf(1));
        assertTrue(list.contains(2));

        UnaryOperator<Integer> addOne = x -> x + 1;
        list.replaceAll(addOne);
        assertEquals(2,list.get(0));

        list.clear();
        assertEquals(0,list.size());



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
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4);

        Iterator<Integer> iterator= list.iterator();

        while (iterator.hasNext()){
            if (iterator.next()==2){
                iterator.remove();
            }
        }
        assertFalse(list.contains(2));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list=new ArrayList<>(3);
        Collections.addAll(list,1,2,3);
        list.sort(Comparator.reverseOrder());

        assertEquals(0,list.indexOf(3));
    }
}
