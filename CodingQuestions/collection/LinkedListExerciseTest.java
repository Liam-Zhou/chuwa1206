package com.chuwa.exercise.collection;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import static java.util.Collections.*;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // create linkedlist
        LinkedList<String> animals = new LinkedList<>();

        // add() method without the index parameter
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cow");
        System.out.println("LinkedList: " + animals);

        //Using addLast() method
        animals.addLast("Tiger");
        System.out.println("Added last LL " + animals);

        // add() method with the index parameter
        animals.add(1, "Horse");
        System.out.println("Updated LinkedList: " + animals);

        //Using addFirst() method
        animals.addFirst("Duck");
        System.out.println("Added first LL " + animals);

        //Using addAll() method
        LinkedList<String> sub_animals = new LinkedList<>();
        sub_animals.add("Chick");
        sub_animals.add("Snake");

        animals.addAll(0, sub_animals);
        System.out.println("List after addAll " + animals);

        //Using getFirst() method
        System.out.println("First element " + animals.getFirst());

        //Using getLast() method
        System.out.println("Last element " + animals.getLast());

        //Using get(idx) method;
        System.out.println("Get #2 element " + animals.get(2));
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<String> languages = new LinkedList<>();

        // add elements in LinkedList
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("Kotlin");
        languages.add("R");
        languages.add("CPP");
        System.out.println("LinkedList: " + languages);

        // remove elements from index 1
        String str = languages.remove(1);
        System.out.println("Updated LinkedList: " + languages);

        //Using removeFist() method
        String str1 = languages.removeFirst();
        System.out.println("Updated LinkedList: " + languages);

        //Using removeLast() method
        String str2 = languages.removeLast();
        System.out.println("Updated LinkedList: " + languages);

        //Using remove() method
        String str3 = String.valueOf(languages.remove("R"));
        System.out.println("Updated LinkedList: " + languages);

        //Using removeLastOccurrence() method
        System.out.println("Occ list " + languages.removeLastOccurrence("Kotlin"));
        System.out.println("Now list looks like " + languages);

        LinkedList<Integer> num = new LinkedList<>();
        num.add(2);
        num.add(299);
        num.add(-4);

        num.sort(Comparator.naturalOrder());
        System.out.println("Sorted LL " + num);
    }
}
