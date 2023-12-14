package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest<E> extends ArrayList<E> {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> games = new ArrayList<>();
        List<String> bestGames = new ArrayList<>();
        games.add("Dark Soul");
        games.add("Bloodborne");
        games.add("Sekiro");
        assertEquals("Dark Soul", games.get(0));
        assertEquals("Bloodborne", games.get(1));
        assertEquals("Sekiro", games.get(2));
        assertEquals(3, games.size());

        bestGames.add("Elden Ring");
        bestGames.addAll(games);
        assertEquals("Elden Ring", bestGames.get(0));
        assertEquals("Dark Soul", bestGames.get(1));
        assertEquals("Bloodborne", bestGames.get(2));
        assertEquals("Sekiro", bestGames.get(3));

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
        ArrayListExerciseTest<String> games = new ArrayListExerciseTest<>();
        games.add("Dark Soul");
        games.add("Bloodborne");
        games.add("Sekiro");
        games.add("God of War");
        games.add("GTA");
        games.add("RDR2");
        games.add("Darkwood");

        games.remove("Sekiro");
        assertFalse(games.contains("Sekiro"));

        games.remove(0);
        assertFalse(games.contains("Dark Soul"));

        games.removeRange(0,2);
        assertFalse(games.contains("Bloodborne"));
        assertFalse(games.contains("God of War"));

        games.removeAll(List.of("GTA", "RDR2"));
        assertFalse(games.contains("GTA"));
        assertFalse(games.contains("RDR2"));

        games.clear();
        assertEquals(0, games.size());

        games.add("Papers please");
        games.set(0, "Battlefield");
        assertEquals("Battlefield", games.get(0));

        games.add("Stellaris");
        games.add("Stellaris");
        games.replaceAll(s -> "Stellaris".equals(s) ? "Hearts of Iron" : s);
        System.out.println(games);

        assertEquals(0, games.indexOf("Battlefield"));

        games.add("Battlefield");
        assertEquals(3, games.lastIndexOf("Battlefield"));
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
        List<String> games = new ArrayList<>();
        games.add("Dark Soul");
        games.add("Bloodborne");
        games.add("Sekiro");
        games.add("God of War");
        games.add("GTA");
        games.add("RDR2");
        games.add("Darkwood");
        Iterator<String> iterator = games.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Dark Soul", iterator.next());
        iterator.remove();
        assertFalse(games.contains("Dark Soul"));
        iterator.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> nums = new ArrayList<>(List.of(4,5,6,1,3,2));
        nums.sort(Comparator.naturalOrder());
        Collections.sort(nums);
        System.out.println(nums);
        nums.sort(Comparator.reverseOrder());
        System.out.println(nums);
    }
}
