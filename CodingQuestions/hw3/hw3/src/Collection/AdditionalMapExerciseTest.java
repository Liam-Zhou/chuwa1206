package Collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("s100", 100);
        map.putIfAbsent("s200", 200);
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.put("1", 1);
        map.putAll(map2);
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.println("Today is: " + dayOfWeek);
        System.out.println("Tomorrow will be: " + dayOfWeek.plus(1));
        map.put(dayOfWeek.MONDAY, 1);
        map.putIfAbsent(dayOfWeek.TUESDAY, 2);
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        enumMap.put(DayOfWeek.MONDAY, 10);
        enumMap.put(DayOfWeek.TUESDAY, 20);
        enumMap.put(DayOfWeek.WEDNESDAY, 30);
        enumMap.put(DayOfWeek.THURSDAY, 40);
        enumMap.put(DayOfWeek.FRIDAY, 50);
        enumMap.put(DayOfWeek.SATURDAY, 60);
        enumMap.put(DayOfWeek.SUNDAY, 70);

        System.out.println("Value for Monday: " + enumMap.get(DayOfWeek.MONDAY));
        System.out.println("Value for Friday: " + enumMap.get(DayOfWeek.FRIDAY));
    }
}
