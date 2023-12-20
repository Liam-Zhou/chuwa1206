package java8.features.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("a", 1),
                new Person("b", 2),
                new Person("c", 3));

        people.sort((p1, p2) -> Person.compareByName(p1, p2));
        people.sort(Person::compareByName);

        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);

        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("1", "2", "3");
        names.sort(String::compareToIgnoreCase);

        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("4", 6);

        System.out.println(people);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByName(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
