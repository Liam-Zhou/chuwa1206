package hw3.CollectionPractice;

import org.junit.Test;
import java.util.Collections;
import java.util.List;

public class CollectionsExerciseTest {

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = List.of(1, 3, 2, 4, 5);

        int minValue = Collections.min(list);
        int maxValue = Collections.max(list);

        int frequencyOfTwo = Collections.frequency(list, 2);
    }

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> synchronizedList = Collections.synchronizedList(List.of(1, 3, 2, 4, 5));

        // This list is now thread-safe, but you should still synchronize
        // on the returned list when iterating over it or performing multiple operations.
    }
}

