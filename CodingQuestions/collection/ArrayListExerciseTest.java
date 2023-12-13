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
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        System.out.println("A1" + arr1);
        System.out.println("A2" + arr2);

        for (int i = 1; i < 5; i ++) {
            arr1.add(i);
        }
        System.out.println("A1" + arr1);

        //getting the element at idx 2
        int a = arr1.get(2);
        System.out.println("IDX" + a);

        arr2.add(30);
        arr2.addAll(arr1);
        System.out.println("A2" + arr2);
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
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("hello");
        arr1.add("886");
        arr1.add("Friday");
        arr1.add("Sat.");
        arr1.add("5");
        arr1.add("o");
        arr1.add("pp");
        System.out.println("A1" + arr1);
        arr1.remove(0);
        System.out.println("A1_v1" + arr1);
        arr1.remove("886");
        System.out.println("A1_v2" + arr1);

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("886");
        arr2.add("Sat.");
        arr2.add("o");
        arr1.removeAll(arr2);
        System.out.println("after remove all" + arr1);

        arr2.clear();
        System.out.println("arr2 after clear()" + arr2);

        ArrayList<Integer>
                arrlist = new ArrayList<Integer>();

        arrlist.add(1);
        arrlist.add(2);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(5);

        // print arrlist
        System.out.println("Before operation: "
                + arrlist);

        int i = arrlist.set(3, 30);

        System.out.println("After operation: "
                + arrlist);

        System.out.println("Replaced element: "
                + i);

        ArrayList<String> languages = new ArrayList<>();

        // add elements to the ArrayList
        languages.add("java");
        languages.add("javascript");
        languages.add("swift");
        languages.add("python");
        System.out.println("ArrayList: " + languages);

        // replace all elements to uppercase
        languages.replaceAll(e -> e.toUpperCase());
        System.out.println("Updated ArrayList: " + languages);

        System.out.println("contains " + arr1.contains("pp"));
        System.out.println("index of " + arr1.indexOf("Friday"));
        System.out.println("last idx of " + arr1.lastIndexOf("Sat."));
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
        ArrayList<String> languages = new ArrayList<>();

        // Add elements in the array list
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("Swift");

        // Create a variable of Iterator
        // store the iterator returned by iterator()
        Iterator<String> iterate = languages.iterator();
        System.out.println("Element: Index");

        // loop through ArrayList till it has all elements
        // Use methods of Iterator to access elements
        while(iterate.hasNext()){

            // access element
            String element = iterate.next();
            System.out.print(element + ": ");

            // access index of each element
            System.out.println(languages.indexOf(element));
        }
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(3);
        numbers.add(9);
        numbers.add(-33);
        System.out.println("Unsorted ArrayList: " + numbers);
        
        // sort the ArrayList in ascending order
        Collections.sort(numbers);
        System.out.println("sorted numbers " + numbers);
        numbers.sort(Comparator.reverseOrder());
        System.out.println("Sorted reversly ArrayList: " + numbers);
    }
}
