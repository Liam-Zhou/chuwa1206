package com.chuwa.exercise.collection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = new LinkedList<Integer>();

        // populate the list
        list.add(10);
        list.add(10);
        list.add(30);
        list.add(40);

        // printing the List
        System.out.println("List: " + list);

        // getting minimum value
        // using min() method
        int min = Collections.min(list);
        // printing the min value
        System.out.println("Minimum value is: " + min);

        //Using max()
        int max = Collections.max(list);
        // printing the max value
        System.out.println("Max value is: " + max);

        //Using freq()
        List<String>  mylist = new ArrayList<String>();
        mylist.add("practice");
        mylist.add("code");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("geeksforgeeks");

        // Here we are using frequency() method
        // to get  frequency of element "code"
        int freq = Collections.frequency(mylist, "code");
        System.out.println(freq);
}

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // creating object of List<String>
        List<String> list = new ArrayList<String>();

        // populate the list
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // printing the Collection
        System.out.println("List : " + list);

        // create a synchronized list
        List<String> synlist = Collections
                .synchronizedList(list);

        // printing the Collection
        System.out.println("Synchronized list is : " + synlist);
    }
}