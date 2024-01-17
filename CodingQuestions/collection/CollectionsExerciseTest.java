package com.chuwa.exercise.collection;
import java.util.*;
import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 1, 4);

        // 获取最小值
        int min = Collections.min(numbers);
        System.out.println("最小值: " + min);

        // 使用 Comparator 获取最小值
        int minWithComp = Collections.min(numbers, Comparator.naturalOrder());
        System.out.println("使用 Comparator 的最小值: " + minWithComp);

        // 获取最大值
        int max = Collections.max(numbers);
        System.out.println("最大值: " + max);

        // 使用 Comparator 获取最大值
        int maxWithComp = Collections.max(numbers, Comparator.naturalOrder());
        System.out.println("使用 Comparator 的最大值: " + maxWithComp);

        // 计算元素频率
        int frequency = Collections.frequency(numbers, 3);
        System.out.println("数字3的频率: " + frequency);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 创建一个线程安全的 list
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        // 现在 synchronizedList 是线程安全的
        System.out.println("线程安全的 list: " + synchronizedList);
    }
}
