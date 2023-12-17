package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // 初始化 ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 添加元素
        list.add("Day1");
        list.add("Day2");
        list.add("Day3");

        // 获取元素
        System.out.println("Element at index 1: " + list.get(1)); // 输出 "Day2"

        // 获取大小
        System.out.println("Size of list: " + list.size()); // 输出列表的大小

        // 创建另一个列表并初始化
        ArrayList<String> anotherList = new ArrayList<>(Arrays.asList("Day4", "Day5", "Day6"));

        // 将另一个列表的元素全部添加到当前列表中
        list.addAll(anotherList);

        // 显示更新后的列表
        System.out.println("Updated list: " + list);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // 初始化 ArrayList
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Day1", "Day2", "Day3", "Day4", "Day5"));

        // 移除元素
        list.remove(2); // 移除索引为 2 的元素（Day3）
        list.remove("Day2"); // 移除 "Day2"

        // 移除指定范围内的元素
        list.subList(1, 2).clear(); // 移除索引 1 到 1（不包括 2）的元素（Day4）

        // 移除集合中的所有元素
        List<String> toRemove = Arrays.asList("Day1");
        list.removeAll(toRemove);

        // 清空列表
        list.clear();

        // 再次初始化列表用于其他操作
        list.addAll(Arrays.asList("Day1", "Day2", "Day3", "Day4", "Day5"));

        // 更新元素
        list.set(0, "NewDay1"); // 将索引 0 的元素替换为 "NewDay1"

        // 替换所有元素
        UnaryOperator<String> operator = s -> "Updated" + s.substring(s.length() - 2); // 将所有元素加上前缀 "Updated"
        list.replaceAll(operator);

        // 检查元素
        boolean containsDay3 = list.contains("UpdatedDay3");
        int indexOfDay2 = list.indexOf("UpdatedDay2");
        int lastIndexOfDay4 = list.lastIndexOf("UpdatedDay4");

        // 输出结果
        System.out.println("Updated list: " + list);
        System.out.println("Contains 'UpdatedDay3': " + containsDay3);
        System.out.println("Index of 'UpdatedDay2': " + indexOfDay2);
        System.out.println("Last index of 'UpdatedDay4': " + lastIndexOfDay4);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        // 初始化 ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Day1");
        list.add("Day2");
        list.add("Day3");

        // 获取迭代器
        Iterator<String> iterator = list.iterator();

        // 使用 hasNext() 和 next() 方法迭代
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Processing: " + element);

            // 条件删除
            if (element.equals("Day2")) {
                iterator.remove(); // 移除 "Day2"
            }
        }

        // 显示移除元素后的列表
        System.out.println("List after removal: " + list);

        // 使用 forEachRemaining() 遍历剩余元素
        iterator = list.iterator(); // 重新获取迭代器
        Consumer<String> action = element -> System.out.println("Remaining: " + element);
        iterator.forEachRemaining(action);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        // 初始化 ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Day3");
        list.add("Day1");
        list.add("Day2");

        // 使用 Collections.sort() 进行自然排序（升序）
        Collections.sort(list);
        System.out.println("Sorted list (natural order): " + list);

        // 使用 List.sort() 和 Comparator 进行自定义排序（这里仍然是升序）
        list.sort(Comparator.naturalOrder());
        System.out.println("Sorted list (using list.sort()): " + list);

        // 使用 Collections.sort() 和 Comparator.reverseOrder() 进行降序排序
        list.sort(Comparator.reverseOrder());
        System.out.println("Sorted list (reverse order): " + list);
    }

    public static void main(String[] args) {

        ArrayListExerciseTest test = new ArrayListExerciseTest();
        test.learn_Inserting_And_Retrieving();
        test.learn_Remove_Replacing_Updating();
        test.learn_Iterator();
        test.learn_Sorting();

    }
}
