package CollectionPractice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LinkedHashMapPractice {
    public static void main(String[] args) {
        // 1. learn_Inserting_And_Retrieving
        HashMap<String, Integer> map = new LinkedHashMap<>();
        HashMap<String, Integer> map2 = new LinkedHashMap<>();
        map.put("Tom", 2);
        map.putIfAbsent("James", 3);
        map.putAll(map2);

        map.get("Tom");
        map.getOrDefault("James", 20);

        map.containsKey("James");
        map.containsValue(2);

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());
        // 2. learn_Remove_Replacing_Updating
        map.replace("Tom", 10, 20);
        map.replace("Tom", 20);
        map.replaceAll((key, value) -> value * 2);

        map.remove("Tom");
        map.remove("Tom", 10);

        map.compute("sz", (key, value) -> 30);
        map.computeIfAbsent("sz", value -> value.length());
        map.computeIfPresent("sz", (key, value) -> value + 100);
    }
}
