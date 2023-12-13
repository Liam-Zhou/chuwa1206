package hw3.CollectionPractice;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExerciseTest {

    /**
     * e.g.
     * Set<Integer> set = new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        // Creating a new TreeSet
        Set<String> set = new TreeSet<>();

        // Inserting elements
        set.add("Apple"); // add(E e)
        set.add("Banana");
        set.addAll(Set.of("Orange", "Mango")); // addAll(Collection<> c)

        // Retrieving elements
        System.out.println("Set: " + set);
        System.out.println("Contains 'Banana': " + set.contains("Banana"));

        // Accessing first and last elements
        System.out.println("First element: " + ((TreeSet<String>) set).first());
        System.out.println("Last element: " + ((TreeSet<String>) set).last());

        // Retrieving subsets
        System.out.println("Subset (Banana to Mango): " + ((TreeSet<String>) set).subSet("Banana", "Mango"));
        System.out.println("Headset (up to Orange): " + ((TreeSet<String>) set).headSet("Orange"));
        System.out.println("Tailset (from Banana): " + ((TreeSet<String>) set).tailSet("Banana"));

        // Removing elements
        set.remove("Banana");
        System.out.println("Set after removing 'Banana': " + set);

        // Checking size and emptiness
        System.out.println("Size of set: " + set.size());
        System.out.println("Is set empty? " + set.isEmpty());
    }
}