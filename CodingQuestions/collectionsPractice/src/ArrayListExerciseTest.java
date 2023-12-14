import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static org.junit.Assert.*;

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
        list.add(2);
        int firstNum = list.get(0);
        int secondNum = list.get(1);
        int length = list.size();
        List<Integer> anotherList = Arrays.asList(3, 4, 5);
        list.addAll(anotherList);
        int lengthAfter = list.size();
        assertEquals(0, firstNum);
        assertEquals(1, secondNum);
        assertEquals(3, length);
        assertEquals(6, lengthAfter);
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
        list.add(100);
        assertEquals(list.size(), 3);
        list.remove(0);
        assertEquals(list.get(0), (Integer) 1);
        list.remove((Integer) 100);
        assertFalse(list.contains(100));
        list.clear();
        assertTrue(list.isEmpty());

        List<String> strList = Arrays.asList("A", "B", "B", "C");
        strList.set(0, "X");
        assertTrue(strList.contains("X"));
        UnaryOperator<String> operator = String::toLowerCase;
        strList.replaceAll(operator);
        assertEquals(strList.indexOf("x"), 0);
        assertEquals(strList.lastIndexOf("b"), 2);
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
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        iterator.remove();
        assertFalse(list.contains("A"));
        Consumer<String> action = s -> list.set(list.indexOf(s), s.toLowerCase());
        iterator.forEachRemaining(action);
        assertTrue(list.containsAll(Arrays.asList("b", "c")));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,2,1,4));
        Collections.sort(list);
        assertEquals(Arrays.asList(1,2,3,4), list);
        list.sort(Comparator.reverseOrder());
        assertEquals(Arrays.asList(4,3,2,1), list);
    }
}
