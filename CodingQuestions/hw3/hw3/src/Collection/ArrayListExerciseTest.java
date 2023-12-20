package Collection;

import org.junit.Test;

import java.util.*;
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
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.get(0);
        lst.size();
        List<Integer> lst2 = new ArrayList<>();
        lst2.add(2);
        lst.addAll(lst2);
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
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");
        myList.add("Elderberry");
        myList.add("Fig");
        myList.add("Grape");


        myList.remove(1);
        myList.remove("Cherry");
        myList.subList(2, 4).clear();
        ArrayList<String> toRemove = new ArrayList<>();
        toRemove.add("Fig");
        toRemove.add("Grape");
        myList.removeAll(toRemove);

        myList.set(0, "Apricot");
        UnaryOperator<String> operator = String::toUpperCase;
        myList.replaceAll(operator);

        boolean contains = myList.contains("BANANA");
        int index = myList.indexOf("BANANA");
        int lastIndex = myList.lastIndexOf("BANANA");

        System.out.println("Updated List: " + myList);
        System.out.println("Contains 'BANANA': " + contains);
        System.out.println("Index of 'BANANA': " + index);
        System.out.println("Last index of 'BANANA': " + lastIndex);
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
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);

            if (fruit.equals("Cherry")) {
                iterator.remove();
            }
        }

        System.out.println("\nRemaining Elements:");
        iterator = fruits.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);

        numbers.sort(Collections.reverseOrder());
        System.out.println("Sorted in descending order: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted in ascending order: " + numbers);

        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Sorted in descending order: " + numbers);
    }
}
