package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
        Collections.addAll(list,1,2,3,4);
        list.add(5);
        list.addIfAbsent(6);

        assertTrue(list.contains(6));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
        Collections.addAll(list,1,2,3,4);


        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()){
            if(itr.next()==3){
                System.out.println("Yeah!!");
            }
        }
    }
}
