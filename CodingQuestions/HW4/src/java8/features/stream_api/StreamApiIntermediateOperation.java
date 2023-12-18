package java8.features.stream_api;

import java8.t00_common.pojos.Employee;
import java8.t00_common.utils.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiIntermediateOperation {

    @Test
    public void testFilter() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = col.stream();
        stream.filter(t -> t % 2 == 0).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employees.stream();
        employeeStream.map(Employee::getName)
                .filter((name) -> name.length() > 6)
                .forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().skip(2).forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        List<Integer> col = Arrays.asList(1, 2, 1, 2);
        Stream is = col.stream();
        is.distinct().forEach(System.out::println);
    }


    @Test
    public void testMap() {
        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5");
        List<String> list2 = Arrays.asList("6", "7", "8", "9", "10");

        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(list1);
        listsOfStrings.add(list2);
        System.out.println(listsOfStrings);

        System.out.println("Find the max value");
//        输出是list转换的stream对象
        Stream<String> stringStream = listsOfStrings.stream().flatMap(list -> list.stream());
//        输出是list转换的Stream<Stream>对象
        Stream<Stream<String>> streamStream = listsOfStrings.stream().map(list -> list.stream());

        OptionalInt max = stringStream.mapToInt(Integer::parseInt).max();
        System.out.println(max.getAsInt());


        // 2.
        int asInt1 = listsOfStrings
                .stream()
                .flatMap(list -> list.stream())
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();

        System.out.println(asInt1);
    }

    @Test
    public void testIntermediateOperationChain() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> collect = list2
                .stream()
                .filter((value) -> value % 2 == 0)
                .map(value -> value * 10)
                .collect(Collectors.toList());

        list1.addAll(collect);
        System.out.println(list1);
    }

    @Test
    public void testSorted() {
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);

        System.out.println("\n***********\n");

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);

        System.out.println("\n********* equals ***************\n");
        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}
