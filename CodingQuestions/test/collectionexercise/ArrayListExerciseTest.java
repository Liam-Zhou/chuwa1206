package collectionexercise;

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
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        assert list.get(0)==1;
        assert list.size()==1;
        list.addAll(List.of(3,4,5));
        assert list.size()==4;
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
        ArrayList<Integer> list=new ArrayList<>(List.of(1,2,3,4,5));
        list.remove(0);
        list.remove(Integer.valueOf(4)); // 2,3,5
        assert list.get(1)==3;
        list.set(0,100);
        assert list.get(0)==100;
        assert list.get(1)==3;
        list.replaceAll(a->a+1);
        assert list.get(1)==4;
        assert list.contains(4);
        assert list.indexOf(4)==1;
        assert list.lastIndexOf(4)==1;
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
        ArrayList<Integer> list=new ArrayList<>(List.of(1,2,3,4,5));
        Iterator<Integer> i=list.iterator();
        if(i.hasNext()){
            assert i.next()==1;
            i.remove();
        }
        assert list.get(0)==2;

        i.forEachRemaining(j-> System.out.println(j));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list=new ArrayList<>(List.of(1,4,5,3,2));
        Collections.sort(list,Comparator.reverseOrder());
        assert list.get(0)==5;
    }
}
