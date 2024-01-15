package com.chuwa.exercise.collection;

import org.junit.Test;

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
        ArrayList<String> list = new ArrayList<>();

        // Demonstrating the 'add' method
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");

        // Demonstrating the 'get' method and 'size' method
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i));
        }

        // Demonstrating the 'addAll' method
        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Element4");
        anotherList.add("Element5");
        list.addAll(anotherList);

        // Printing the list to verify the operations
        list.forEach(element -> System.out.println("List contains: " + element));

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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Element1", "Element2", "Element3", "Element4", "Element5"));
        list.remove(0); // remove element at index 0
        list.remove("Element3"); // remove "Element3"

        // Demonstrating 'removeRange' method - requires a subclass as it's protected in ArrayList
        ArrayList<String> sublist = new ArrayList<String>(list) {
            public void removeRange(int fromIndex, int toIndex) {
                super.removeRange(fromIndex, toIndex);
            }
        };
        sublist.removeRange(1, 2); // remove elements from index 1 to 2 (exclusive)

        // Demonstrating 'removeAll' method
        ArrayList<String> itemsToRemove = new ArrayList<>(Arrays.asList("Element1", "Element4"));
        list.removeAll(itemsToRemove);

        // Demonstrating 'clear' method
        list.clear();

        // Demonstrating 'set' method (update)
        list.addAll(Arrays.asList("Element1", "Element2", "Element3"));
        list.set(1, "UpdatedElement"); // update element at index 1

        // Demonstrating 'replaceAll' method
        list.replaceAll(element -> element.toUpperCase()); // replace all elements with their uppercase version

        // Check operations
        boolean contains = list.contains("UpdatedElement"); // check if list contains "UpdatedElement"
        int indexOf = list.indexOf("UpdatedElement"); // get the index of "UpdatedElement"
        int lastIndexOf = list.lastIndexOf("UpdatedElement"); // get the last index of "UpdatedElement"

        // Printing the list and checks to verify the operations
        list.forEach(element -> System.out.println("List contains: " + element));
        System.out.println("Contains UpdatedElement: " + contains);
        System.out.println("Index of UpdatedElement: " + indexOf);
        System.out.println("Last index of UpdatedElement: " + lastIndexOf);
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Element1", "Element2", "Element3"));

        // Using iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("Element2")) {
                iterator.remove(); // remove "Element2"
            }
        }

        // Demonstrating 'forEachRemaining' method
        iterator = list.iterator();
        iterator.forEachRemaining(element -> System.out.println("Remaining element: " + element));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry", "Date"));

        // Sorting the list in natural order
        Collections.sort(list);
        list.forEach(element -> System.out.println("Sorted list (natural order): " + element));

        // Sorting the list in reverse order using Comparator.reverseOrder()
        Collections.sort(list, Comparator.reverseOrder());
        list.forEach(element -> System.out.println("Sorted list (reverse order): " + element));


    }
}
