package coding2.collection;

import org.junit.Test;

import java.util.*;


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
        System.out.println(list.size());
        List<Integer> list2 = Arrays.asList(1,2,3,4);
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(8);
        System.out.println(list.remove(0));
//        System.out.println(list.removeRange(0,5)); remove range is protected method
        System.out.println(list.removeAll(Arrays.asList(1,2,9)));
        System.out.println(list);
        list.clear();
        System.out.println(list.size());

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(8);
        list.set(0,100);
        System.out.println(list);
        list.replaceAll(k -> k == 1 ? 200 : -200);
        System.out.println(list);

        System.out.println(list.contains(-200));
        System.out.println(list.indexOf(-200));
        System.out.println(list.lastIndexOf(-200));
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(8);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }
        System.out.println(list);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(8);
        list.sort((a, b) -> (a - b));
        System.out.println(list);
        Collections.sort(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }
}
