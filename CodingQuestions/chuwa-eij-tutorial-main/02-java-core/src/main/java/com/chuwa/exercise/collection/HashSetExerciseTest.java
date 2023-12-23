package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HashSetExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        // Test add method
        assertTrue(set.add(1));
        assertFalse(set.add(1)); // Adding a duplicate should return false

        // Test addAll method
        Set<Integer> newNumbers = new HashSet<>(Arrays.asList(2, 3));
        assertTrue(set.addAll(newNumbers));
        assertEquals(3, set.size());

        // Test contains method
        assertTrue(set.contains(1));
        assertFalse(set.contains(4));

        // Test remove method
        assertTrue(set.remove(1));
        assertFalse(set.remove(4)); // Removing a non-existent element should return false

        // Test clear method
        set.clear();
        assertTrue(set.isEmpty());

        // Test isEmpty method
        assertTrue(set.isEmpty());
    }
}
