

import org.junit.Test;


import java.util.*;

import static org.junit.Assert.assertEquals;

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
        list.add(2);
        int firstEle = list.get(0);
        assertEquals(1, firstEle);
        int size = list.size();
        assertEquals(2, size);
        List<Integer> listTest = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.addAll(Arrays.asList(3, 4, 5, 6));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), listTest);

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
    public class rangeRemoveSupport<E> extends ArrayList<E> {

        public void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
        }
    }
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<String> list = new ArrayList<>(Arrays.asList("zero", "first", "second", "third", "fourth", "fifth", "sixth"));
        // remove(int index)
        list.remove(2);
        List<String> listTest1 = Arrays.asList("zero", "first", "third", "fourth", "fifth", "sixth");
        assertEquals(listTest1, list);

        // remove(Object o)
        list.remove("zero");
        List<String> listTest2 = Arrays.asList("first", "third", "fourth", "fifth", "sixth");
        assertEquals(listTest2, list);

        // removeRange(int fromIndex, int toIndex)
        rangeRemoveSupport arr = new rangeRemoveSupport();
        arr.add("zero");
        arr.add("first");
        arr.add("second");
        arr.add("third");
        arr.add("forth");
        arr.add("fifth");
        arr.add("sixth");
        arr.removeRange(0, 3);
        List<String> listTest3 = Arrays.asList("third", "forth", "fifth", "sixth");
        assertEquals(listTest3, arr);

        // removeAll(Collection<?> c)
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 4, 5));

        list2.removeAll(list3);
        List<Integer> listTest4 = Arrays.asList(1, 2);
        assertEquals(listTest4, list2);

        // clear()
        List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        list4.clear();
        List<Integer> listTest5 = new ArrayList<>();
        assertEquals(listTest5, list4);

        List<Integer> list5 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        // Update:
             // set(int index, E e)
        list5.set(0, 0);
        List<Integer> listTest6 = Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(listTest6, list5);
             // replaceAll(UnaryOperator<E> operator)
        list5.replaceAll(e -> e * 2);
        List<Integer> listTest7 = Arrays.asList(0, 4, 6, 8, 10, 12, 14, 16);
        assertEquals(listTest7, list5);

       // check:
            // contains(Object o)
        assertEquals(true, list5.contains(0));
        assertEquals(false, list5.contains(1));

            // indexOf(Object o)
        assertEquals(4, list5.indexOf(10));
            // lastIndexOf(Object o)
        list5.add(10); // 插入到整个数组的最后面了, arrayList会按照插入顺序进行存储
        assertEquals(8, list5.lastIndexOf(10));

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
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        // iterator()
        ListIterator<Integer> iterator = list.listIterator();

        // hasNext(), next(), remove()
        Integer i = 0;

        while (iterator.hasNext()) {
            // next执行一次就跑到下一个位置去了
            Integer element = iterator.next();
            assertEquals(i++, element);

            if (element == 0) {
                iterator.remove();
            }
        }
        List<Integer> test = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertEquals(test, list);
        // forEachRemaining(Consumer<? super E> action) -- from Java8
            // variable that used in lambda function should be final
        iterator.forEachRemaining((number) -> System.out.println(number));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        // sort(List<T> list), Collections.sort(List<T> t)
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 3, 4, 6, 8, 1, 0, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 4, 6, 8, 1, 0, 3));
        list1.sort(Comparator.naturalOrder());
        Collections.sort(list2);
        assertEquals(list1, list2);

        // Comparator.reverseOrder()
        list1.sort(Comparator.reverseOrder());
        List<Integer> test = Arrays.asList(8, 6, 4, 3, 3, 2, 1, 0);
        assertEquals(test, list1);
    }
}
