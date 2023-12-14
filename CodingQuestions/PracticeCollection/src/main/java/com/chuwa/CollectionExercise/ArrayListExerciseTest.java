package com.chuwa.CollectionExercise;

import org.junit.Test;

import java.util.*;

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
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.remove(1); // remove index
        System.out.println(lst);
        lst.remove(Integer.valueOf(3)); // remove object
        System.out.println(lst);


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
        List<Integer> lst2 = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(lst2.contains(4));
        System.out.println(lst2.subList(0,4));

        ArrayList<Integer> arrlst = new ArrayList<>();
        arrlst.add(1);
        arrlst.add(1);
        arrlst.add(1);
        arrlst.add(1);
        //arrlst.removeRange(0,2);//'removeRange(int, int)' has protected access in 'java.util.ArrayList'
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
        List<Integer> lst2 = Arrays.asList(1,2,3,4,5,6,7);
        ListIterator<Integer> iter = lst2.listIterator(); //initialized to point to the one before begin()
        while(iter.hasNext()){
            System.out.println(iter.next()); //next() return the next element
        }
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> lst3 = Arrays.asList(3,1,5,6,2,4,7);
        Collections.sort(lst3);
        System.out.println(lst3);

        Collections.sort(lst3, new MyCompare());
        System.out.println(lst3); // reverse
    }

    public class MyCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

}