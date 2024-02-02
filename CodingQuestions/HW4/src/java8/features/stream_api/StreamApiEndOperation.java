package java8.features.stream_api;

import java8.t00_common.pojos.Employee;
import java8.t00_common.utils.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEndOperation {

    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();

    @Test
    public void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    /**
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     */

    @Test
    public void testMatch() {
//        1， allMatch(Predicate p) - 检查是否匹配所有的元素
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);
//        2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() < 10);
        System.out.println(anyMatch);
//        3， noneMatch(Predicate p) - 检查是否没有匹配的元素
        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName() == "tom");
        System.out.println(noneMatch);
    }

    /**
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     */

    @Test
    public void testFind() {
//        4. findFirst(), it return an optional type
        Optional<Employee> employee = EMPLOYEES.stream().findAny();
        System.out.println(employee);

//        5. findAny(),
        Optional<Employee> any = EMPLOYEES.stream().findAny();
        System.out.println(any);
    }

    /**
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     */

    @Test
    public void testCountMaxMin() {
        long count = EMPLOYEES.stream().count();
        System.out.println(count);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println("max age is: " + max);

        Optional<Employee> min = EMPLOYEES.stream()
                .min(Comparator.comparingInt(Employee::getId));
        System.out.println("min age is : " + min);

        EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " ： OLD PPL")
                .forEach(System.out::println);

        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40).map(e -> e.getName() + " ： OLD PPL")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 9, forEach(Consumer c) - 内部迭代
     * 使用集合的迭代
     */
    @Test
    public void testIteration() {
//      forEach(Consumer c) - 内部迭代
        EMPLOYEES.stream().forEach(System.out::println);

        System.out.println("\n********************************\n");
        // 使用集合的迭代
        EMPLOYEES.forEach(System.out::println);
    }

    // reduce
    @Test
    public void testReduce() {
        // 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer reduce = list.stream().reduce(10, Integer::sum);
        System.out.println(reduce);

        // 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce2.get());
    }

    /**
     * map是必须要有return的, 在collect终止条件之后，仍然可以接 .stream() 继续处理
     */
    @Test
    public void testChain() {
        List<Double> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("********************");

        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());

        // 在终止操作后，可以继续跟一个新的.stream()来构建chain.
        Optional<Integer> reduce1 = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .collect(Collectors.toList())
                .stream()
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 获得员工中，男性员工中最高工资的人，以及女性员工中最高工资的人
     */
    @Test
    public void testGroupBy() {
        Map<String, Optional<Employee>> collect = EMPLOYEES
                .stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("male max salary: " + collect.get("male"));
        System.out.println("female max salary: " + collect.get("female"));
    }

    /**
     * 构建一个map, key是员工ID，value是员工的工资。
     */
    @Test
    public void testToMap() {
        Map<Integer, Double> collect = EMPLOYEES.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getSalary
                ));
    }
}
