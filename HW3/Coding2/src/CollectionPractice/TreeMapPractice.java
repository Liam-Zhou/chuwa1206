package CollectionPractice;

import java.util.TreeMap;

public class TreeMapPractice {
    public static void main(String[] args) {
        // 1. learn_Inserting_And_Retrieving
        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map.put("abc", 1);
        map.putIfAbsent("bcd", 3);
        map.putAll(map2);

        map.get("abc");
        map.firstKey();
        map.lastKey();

        map.containsKey("abc");
        map.containsValue("bcd");

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());
        // 2. learn_Remove_Replacing_Updating
        map.replace("abc", 1, 5);
        map.replace("abc", 3);
        map.remove("bcd");
    }
}
