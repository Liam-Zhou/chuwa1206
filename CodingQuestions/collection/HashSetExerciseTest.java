package com.chuwa.exercise.collection;
import org.junit.Test;

import java.util.HashSet;
import java.util.StringJoiner;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        HashSet<String> evenNumber = new HashSet<>();

        // Using add() method
        evenNumber.add("TWO");
        evenNumber.add("FOUR");
        evenNumber.add("SIX");
        System.out.println("HashSet: " + evenNumber);

        HashSet<String> numbers = new HashSet<>();

        // Using addAll() method
        numbers.addAll(evenNumber);
        numbers.add("FIVE");
        System.out.println("New HashSet: " + numbers);

        //Using get();
        String[] nums = numbers.toArray(new String[numbers.size()]);
        System.out.println("element #3 is " + nums[3]);

        //Using contains()
        System.out.println("map contains 2? " + numbers.contains("TWO"));

        //Using remove()
        String str = String.valueOf(numbers.remove("TWO"));
        System.out.println("set after removing " + numbers);

        //Using clear()
        numbers.clear();
        System.out.println("set after clear " + numbers);

        //Using isEmpty()
        System.out.println("is set empty? " + numbers.isEmpty());
    }
}