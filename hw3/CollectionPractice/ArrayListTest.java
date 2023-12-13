package hw3.CollectionPractice;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {


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
            List<Integer> list = new java.util.ArrayList<>();

            // Add elements to the list
            list.add(0);
            list.add(1);
            list.add(3);

            // Get and print elements and size
            System.out.println("Elements: " + list);
            System.out.println("get element at index 0: " + list.get(0));
            System.out.println("get size: " + list.size());

            // Add elements from another list
            list.addAll(List.of(2, 4, 5));
            System.out.println("After adding another list: " + list);
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
            List<Integer> list = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5));

            // Remove operations
            list.remove(2);
            System.out.println("After removing element at index 2: " + list);

            list.remove(Integer.valueOf(4));
            System.out.println("After removing value 4: " + list);

            // Update operations
            list.set(1, 10);
            System.out.println("After updating element at index 1: " + list);

            list.replaceAll(n -> n * 2);
            System.out.println("After doubling each element: " + list);

            // Check operations
            System.out.println("Contains 10: " + list.contains(10));
            System.out.println("Index of 5: " + list.indexOf(5));
            System.out.println("Last index of 20: " + list.lastIndexOf(20));
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
            List<String> stringList = new java.util.ArrayList<>(List.of("apple", "orange", "banana"));

            // Iterator operations
            Iterator<String> iterator = stringList.iterator();
            while (iterator.hasNext()) {
                String fruit = iterator.next();
                System.out.println("Iterator: " + fruit);

                if (fruit.equals("orange")) {
                    iterator.remove();
                }
            }

            // Enhanced for loop (forEachRemaining) from Java 8
            iterator.forEachRemaining(System.out::println);
        }

        /**
         * sort(List<T> list)
         * Collections.sort(List<T> t)
         * Comparator.reverseOrder()
         */

        @Test
        public void learn_Sorting() {
            List<Integer> numbers = new java.util.ArrayList<>(List.of(5, 2, 8, 1, 7));

            // Sorting operations
            Collections.sort(numbers);
            System.out.println("Sorted in natural order: " + numbers);

            Collections.sort(numbers, Collections.reverseOrder());
            System.out.println("Sorted in reverse order: " + numbers);
        }
    }
}
