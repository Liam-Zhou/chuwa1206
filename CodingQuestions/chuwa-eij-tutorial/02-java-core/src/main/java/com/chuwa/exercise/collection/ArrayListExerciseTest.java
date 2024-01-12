package com.chuwa.exercise.collection;

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
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.get(0);
        arr.size();
        arr.addAll(Arrays.asList(2,3,4,5));
        System.out.println(arr);
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
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1, 2,3,4,5));
        arr.remove(0);
        arr.remove(Integer.valueOf(3));
        System.out.println(arr);

        arr.removeAll(Arrays.asList(4,5));

        // update
        System.out.println(arr);
        arr.set(0, 1);
        arr.addAll(Arrays.asList(2,3,4,5));
        System.out.println(arr);

        arr.replaceAll(element -> element * 2);
        System.out.println(arr);

        /* check */
        arr.contains(Integer.valueOf(3)); // false
        arr.contains((Integer.valueOf(4))); // true
        System.out.println(arr.indexOf(Integer.valueOf(4))); // 1
        System.out.println(arr.lastIndexOf(Integer.valueOf(4))); // 1
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
        List<String> arr = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

        Iterator<String> it = arr.iterator();
        while (it.hasNext()){
            String value = it.next();
            System.out.println(value);

            if (value.equals("3")){
                it.remove();
            }
        }

        it = arr.iterator(); // reset iterator
        it.forEachRemaining((elem -> {
            System.out.println("Processed: " + elem);
        }));


        System.out.println("Final List: " + arr);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> arr = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "date"));

        Collections.sort(arr);
        System.out.println("Sorted in natural order: " + arr);

        // Sorts the list with the given comparator
        // Provides a comparator that imposes the reverse of the natural ordering
        Collections.sort(arr, Comparator.reverseOrder());
        System.out.println("Sorted in reverse order: " + arr);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2,3,4,5));
        Collections.sort(numbers, (n1, n2) -> Integer.compare(n1, n1)); // custom comparator
    }
}
