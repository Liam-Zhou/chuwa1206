package java8.features.stream_api;

import java8.t00_common.pojos.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class StreamApiCreationTest {


    // create a stream
    @Test
    public void testCollection() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(System.out::println);

        // 顺序流
        Stream<Integer> stream = list.stream();
        System.out.println(stream);

        // 并行流
        Stream<Integer> parallelStream = list.parallelStream();
        System.out.println(parallelStream);
    }

    @Test
    public void testArrays() {
        int[] arr = new int[]{1, 2, 3};
        IntStream stream = Arrays.stream(arr);
        System.out.println(stream);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println(stream1);
    }

    @Test
    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream);
    }


    //
    @Test
    public void testIterate() {
        Stream.iterate(0, t -> t + 2).limit(5).forEach(System.out::println);
    }

    @Test
    public void testGenerate() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    @Test
    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        // rangeclosed include 3, while range do not include 3
        LongStream longStream = LongStream.rangeClosed(1, 3);

        System.out.println(intStream);
        intStream.forEach(System.out::println);

        System.out.println(longStream);
        longStream.forEach(System.out::println);
    }
}
