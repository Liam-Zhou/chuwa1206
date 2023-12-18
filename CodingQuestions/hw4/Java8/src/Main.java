import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list=new ArrayList<Integer>();

        for(int i=1;i< 10;i++){
            list.add(i);
        }

        Stream<Integer> stream=list.stream();
        Integer[]evenNumbersArr=stream.filter(i->i%2==0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);

        stream=list.stream();
        List<Integer> evenNumbersList = stream
                .filter(i->i%2==0)
                .collect(Collectors.toList());
        System.out.print(evenNumbersList);

        Stream<String> streamEmpty = Stream.empty();
        Collection<String> collection = Arrays.asList("a","b","c");
        Stream<String> streamOfCollection = collection.stream();

        String[]arr=new String[]{"a","b","c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr,1,3);

        // <String> is specified
        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        Stream<String> streamGenerated = Stream.generate(()->"element").limit(10);
        Stream<Integer> streamIterated = Stream.iterate(40,n->n+2).limit(20);

        IntStream intStream = IntStream.range(1,3);
        LongStream longStream = LongStream.rangeClosed(1,3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        IntStream streamOfChars = "abc".chars();

        Path path= Paths.get("C:\\file.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));

        Stream<String> stream2 = Stream.of("a","b","c")
                .filter(element->element.contains("b"));
        Optional<String> anyElement = stream2.findAny();
        Optional<String> firstElement = stream2.findFirst();

        List<String> elements = Stream.of("a","b","c")
                .filter(element->element.contains("b"))
                .collect(Collectors.toList());
        anyElement = elements.stream().findAny();
        firstElement = elements.stream().findFirst();

        List<Integer> list2=new ArrayList<Integer>();
        for(int i = 1;i < 10; i++){
            list2.add(i);
        }


        Stream<Integer> stream3 = list2.parallelStream();
        Integer[] evenNumbersArr2 = stream3
                .filter(i->i%2==0)
                .toArray(Integer[]::new);
        System.out.print(evenNumbersArr2);
    }
}