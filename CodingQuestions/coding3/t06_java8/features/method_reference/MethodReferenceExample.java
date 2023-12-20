package coding3.t06_java8.features.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("john", 30),
                new Person("jun", 30),
                new Person("charlie", 30),
                new Person("dada", 30));

        people.sort((a, b) -> Person.compareByName(a, b));//lambda
        people.sort(Person::compareByName);//method reference

        //实例方法引用(特定对象的实例方法)
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);

        //类的实例方法引用 接受 person 返回string
        Function<Person, String> getNameFunction = Person::getName;
        System.out.println(getNameFunction.apply(people.get(0)));

        //BIfunctin,  Function, Bifunction都是java 中预定义的一些functional  interface
        BiFunction<String, Integer, Person> personBuilder = Person::new;
        Person p1 = personBuilder.apply("huhu", 20);
        System.out.println(p1);
    }


}
