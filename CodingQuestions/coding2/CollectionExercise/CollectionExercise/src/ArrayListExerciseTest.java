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
        list.add(0);
        list.add(1);
        int a = list.get(0);
        int b = list.size();
        System.out.print(a + " " + b);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
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
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.remove(0);
        list.remove(Integer.valueOf(1));
        list.add(0);
        list.add(1);
        list.set(0, 6);
        System.out.println(list.contains(1));
        System.out.println(list.indexOf(0));
        list.add(0);
        System.out.println(list.lastIndexOf(0));
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
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2));
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            iterator.next();
        }
        iterator = list.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2));
        list.sort(Collections.reverseOrder());
        Collections.sort(list);
    }
}
