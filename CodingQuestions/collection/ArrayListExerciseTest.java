package collection;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0));
        System.out.println(list.size());;
        List<Integer> list2 = new ArrayList<>(list);
        list.addAll(list2);
        System.out.println(list);
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
        //removeRange()
         class MyList extends ArrayList<String>{
            public void someMethod() {
                MyList myList = new MyList();
                myList.add("1");
                myList.add("2");
                myList.add("3");
                myList.removeRange(0,2);
            }
        }
        MyList myList = new MyList();
         myList.someMethod();

        //others
        List<String> list = new ArrayList<>();

        list.add("1");
        list.remove(0);
        list.add("2");
        list.add("3");
        list.remove("2");
        list.add("4");
        list.removeAll(Arrays.asList("3", "4"));
        list.add("1");
        list.clear();

        //update
        list.add("B");
        list.set(0, "A");
        list.replaceAll(e -> e.toLowerCase());
        System.out.println(list);

        //check
        System.out.println(list.contains("a"));
        System.out.println(list.indexOf("a"));
        list.add("a");
        System.out.println(list.lastIndexOf("a"));
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
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("a", "c", "b", "g"));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (list.size() > 3) {
                iterator.remove();
            }
        }

        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList("a", "c", "b", "g"));
        Iterator<String> iterator2 = list2.iterator();
        iterator2.forEachRemaining(e -> System.out.println(e.toUpperCase()));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(4,3,6,2,7,0));
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }
}
