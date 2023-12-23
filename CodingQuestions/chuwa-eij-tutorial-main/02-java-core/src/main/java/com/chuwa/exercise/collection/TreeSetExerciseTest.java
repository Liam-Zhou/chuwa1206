package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Set;
import java.util.NavigableSet;

import static org.junit.Assert.*;

public class TreeSetExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();

        // Test add method
        assertTrue(set.add(3));
        assertFalse(set.add(3)); // Adding a duplicate should return false

        // Test addAll method
        assertTrue(set.addAll(Arrays.asList(1, 2, 4, 5)));
        assertEquals(5, set.size());

        // Test contains method
        assertTrue(set.contains(3));
        assertFalse(set.contains(6));

        // Test first() and last()
        assertEquals(Integer.valueOf(1), set.first());
        assertEquals(Integer.valueOf(5), set.last());

        // Test subSet(E fromElement, E toElement)
        Set<Integer> subSet = set.subSet(2, 5);
        assertTrue(subSet.containsAll(Arrays.asList(2, 3, 4)));

        // Test headSet(E toElement)
        Set<Integer> headSet = set.headSet(3);
        assertTrue(headSet.containsAll(Arrays.asList(1, 2)));
        assertFalse(headSet.contains(3));

        // Test tailSet(E fromElement)
        NavigableSet<Integer> tailSet = set.tailSet(3, true);
        assertTrue(tailSet.containsAll(Arrays.asList(3, 4, 5)));

        // Test remove method
        assertTrue(set.remove(3));
        assertFalse(set.remove(6)); // Removing a non-existent element should return false

        // Test size and isEmpty
        assertEquals(4, set.size());
        assertFalse(set.isEmpty());
    }
}
