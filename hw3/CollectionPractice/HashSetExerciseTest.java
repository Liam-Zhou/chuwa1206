package hw3.CollectionPractice;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
        // Creating a new HashSet
        Set<String> set = new HashSet<>();

        // Inserting elements
        set.add("Apple");
        set.add("Banana");
        set.addAll(Set.of("Orange", "Mango"));

        // Retrieving elements
        System.out.println("Set: " + set);
        System.out.println("Contains 'Banana': " + set.contains("Banana"));

        // Removing elements
        set.remove("Banana");
        System.out.println("Set after removing 'Banana': " + set);

        // Clearing the set
        set.clear();
        System.out.println("Set after clearing: " + set);

        // Checking if the set is empty
        System.out.println("Is set empty? " + set.isEmpty());
    }
}
