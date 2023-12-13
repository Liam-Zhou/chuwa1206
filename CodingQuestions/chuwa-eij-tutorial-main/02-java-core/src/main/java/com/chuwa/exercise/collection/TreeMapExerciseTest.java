import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TreeMapExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();

        // Test put method
        assertNull(map.put("Apple", 1));
        assertEquals(Integer.valueOf(1), map.get("Apple"));

        // Test putIfAbsent
        map.putIfAbsent("Banana", 2);
        assertEquals(Integer.valueOf(2), map.get("Banana"));
        map.putIfAbsent("Banana", 3);
        assertEquals(Integer.valueOf(2), map.get("Banana")); // Should not update

        // Test putAll
        Map<String, Integer> newMap = new TreeMap<>();
        newMap.put("Cherry", 3);
        newMap.put("Date", 4);
        map.putAll(newMap);
        assertEquals(Integer.valueOf(3), map.get("Cherry"));
        assertEquals(Integer.valueOf(4), map.get("Date"));

        // Test firstKey and lastKey
        assertEquals("Apple", map.firstKey());
        assertEquals("Date", map.lastKey());

        // Test containsKey and containsValue
        assertTrue(map.containsKey("Apple"));
        assertFalse(map.containsKey("Fig"));
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(5));

        // Test keySet and values
        Set<String> keys = map.keySet();
        assertTrue(keys.containsAll(Arrays.asList("Apple", "Banana", "Cherry", "Date")));
        Collection<Integer> values = map.values();
        assertTrue(values.containsAll(Arrays.asList(1, 2, 3, 4)));

        // Test isEmpty
        assertFalse(map.isEmpty());
    }

    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Test replace methods
        assertEquals(Integer.valueOf(1), map.replace("Apple", 10));
        assertTrue(map.replace("Banana", 2, 20));
        assertFalse(map.replace("Banana", 2, 30)); // oldValue does not match

        // Test remove method
        assertEquals(Integer.valueOf(20), map.remove("Banana"));
    }
}
