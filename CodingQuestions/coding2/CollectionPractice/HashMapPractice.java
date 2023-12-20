package CollectionPractice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        // 1. learn_Inserting_And_Retrieving
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map.put("sz", 1);
        map.putIfAbsent("zc", 12);
        map2.put("zxc", 1);
        map.putAll(map2);

        map.get("sz");
        map.getOrDefault("zc", 2);

        map.containsKey("sz");
        map.containsValue(1);

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());

        // 2. learn_Remove_Replacing_Updating
        map.replace("sz", 1, 3);
        map.replace("sz", 4);
        map.replaceAll((name, number) -> number * 2);

        map.remove("sz");
        map.remove("sz", 4);

        map.compute("sz", (key, value) -> 30);
        map.computeIfAbsent("sz", value -> value.length());
        map.computeIfPresent("sz", (key, value) -> value + 100);
    }
}
