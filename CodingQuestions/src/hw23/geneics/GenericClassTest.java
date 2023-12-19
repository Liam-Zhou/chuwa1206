package hw23.geneics;

public class GenericClassTest {

    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(6);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(100.1);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("String test");
        System.out.println(obj3.getObj());
    }
}
