package CollectionPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsPractice {
    public static void main(String[] args) {
        // 1. learn_common_collections_operations
        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(3);list.add(21);list.add(21);
        int min = Collections.min(list, (o1, o2) -> o1 - o2);
        int max = Collections.max(list, (o1, o2) -> o2 - o1);
        int frequency = Collections.frequency(list, 21);

        // 2. learn_thread_safe_ArrayList
        // Create a normal ArrayList
        List<String> normalList = new ArrayList<>();

        // Populate the list
        normalList.add("Item 1");
        normalList.add("Item 2");
        normalList.add("Item 3");

        // Create a synchronized version of the list
        List<String> synchronizedList = Collections.synchronizedList(normalList);

        // Perform operations on the synchronized list within a synchronized block
        synchronized (synchronizedList) {
            // Iterating and modifying the synchronized list safely
            for (String item : synchronizedList) {
                System.out.println(item);
            }

            synchronizedList.add("New Item");
        }
    }
}
