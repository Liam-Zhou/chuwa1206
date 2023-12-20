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
         List<String> list = new ArrayList<>();
         list.add("Jan");
         list.add("Feb");
         String s = list.get(1);
         int size = list.size();
        System.out.println(s);
        System.out.println("size of list is "+size);
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
        List<String> list = new ArrayList<>(Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        ));
        //remove
        list.remove(0);
        list.remove("Feb");
        list.removeAll(Arrays.asList("November","December"));
        System.out.println("after remove: " + list);

        //update
        list.set(3,"May1");
        list.replaceAll(String::toUpperCase);
        System.out.println("after update: "+ list);

        //check
        System.out.println("contains January ? " + list.contains("January"));
        System.out.println("3rd element: " + list.indexOf((2)));
        System.out.println("last index of August: " + list.lastIndexOf("AUGUST"));


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
        List<String> list = new ArrayList<>(Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        ));
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // Using remove() - Remove elements containing letter 'a'
            if (element.contains("a")) {
                iterator.remove();
            }
        }
        iterator.forEachRemaining(element -> System.out.println("Processing: " + element));
        System.out.println("List after removal: " + list);


    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        ));
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
