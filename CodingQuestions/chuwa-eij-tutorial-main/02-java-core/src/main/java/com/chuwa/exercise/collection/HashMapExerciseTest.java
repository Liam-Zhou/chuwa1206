import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class HashMapExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new HashMap<>();

        // Test put method
        assertNull(map.put("Apple", 1));
        assertEquals(Integer.valueOf(1), map.get("Apple"));

        // Test putIfAbsent
        map.putIfAbsent("Banana", 2);
        assertEquals(Integer.valueOf(2), map.get("Banana"));
        map.putIfAbsent("Banana", 3);
        assertEquals(Integer.valueOf(2), map.get("Banana")); // Should not update

        // Test putAll
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("Cherry", 3);
        newMap.put("Date", 4);
        map.putAll(newMap);
        assertEquals(Integer.valueOf(3), map.get("Cherry"));
        assertEquals(Integer.valueOf(4), map.get("Date"));

        // Test getOrDefault
        assertEquals(Integer.valueOf(1), map.getOrDefault("Apple", 0));
        assertEquals(Integer.valueOf(0), map.getOrDefault("Elderberry", 0));

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
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Test replace methods
        assertEquals(Integer.valueOf(1), map.replace("Apple", 10));
        assertTrue(map.replace("Banana", 2, 20));
        assertFalse(map.replace("Banana", 2, 30)); // oldValue does not match

        // Test replaceAll
        map.replaceAll((k, v) -> v * 2);
        assertEquals(Integer.valueOf(20), map.get("Banana"));
        assertEquals(Integer.valueOf(6), map.get("Cherry"));

        // Test remove methods
        assertEquals(Integer.valueOf(20), map.remove("Banana"));
        assertFalse(map.remove("Cherry", 2)); // value does not match
        assertTrue(map.remove("Cherry", 6));

        // Test compute methods
        map.compute("Apple", (k, v) -> v == null ? 42 : v + 5);
        assertEquals(Integer.valueOf(15), map.get("Apple"));

        map.computeIfAbsent("Fig", k -> 100);
        assertEquals(Integer.valueOf(100), map.get("Fig"));

        map.computeIfPresent("Fig", (k, v) -> v + 50);
        assertEquals(Integer.valueOf(150), map.get("Fig"));
    }
}
