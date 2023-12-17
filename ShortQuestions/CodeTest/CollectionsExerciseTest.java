package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

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
        //初始化List
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        // 寻找最小元素
        int min = Collections.min(numbers);
        System.out.println("Minimum element: " + min);

        // 寻找最大元素
        int max = Collections.max(numbers);
        System.out.println("Maximum element: " + max);

        // 计算特定元素的出现频率
        int frequency = Collections.frequency(numbers, 5);
        System.out.println("Frequency of 5: " + frequency);

        //重新初始化List
        numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        // 定义一个 Comparator，比较数字与5的接近程度
        Comparator<Integer> compareByDistanceToFive = (Integer o1, Integer o2) -> {
            int distance1 = Math.abs(o1 - 5);
            int distance2 = Math.abs(o2 - 5);
            return Integer.compare(distance1, distance2);
        };

        // 使用自定义 Comparator 寻找最小元素
        int closestToFive = Collections.min(numbers, compareByDistanceToFive);
        System.out.println("Element closest to 5: " + closestToFive);

        // 使用自定义 Comparator 寻找最大元素
        int furthestFromFive = Collections.max(numbers, compareByDistanceToFive);
        System.out.println("Element furthest from 5: " + furthestFromFive);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // 创建一个非同步的ArrayList
        List<String> list = new ArrayList<>();

        // 使用 Collections.synchronizedList 包装成线程安全的列表
        List<String> synchronizedList = Collections.synchronizedList(list);

        // 创建并启动两个线程操作同步列表
        Thread thread1 = new Thread(() -> {
            synchronizedList.add("Element 1");
            synchronizedList.add("Element 2");
        });

        Thread thread2 = new Thread(() -> {
            synchronizedList.add("Element 3");
            synchronizedList.add("Element 4");
        });

        thread1.start();
        thread2.start();

        // 等待线程完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印列表内容
        System.out.println("Synchronized list contents: " + synchronizedList);
    }

    public static void main(String[] args) {

        CollectionsExerciseTest test = new CollectionsExerciseTest();
        test.learn_common_collections_operations();
        test.learn_thread_safe_ArrayList();

    }
}
