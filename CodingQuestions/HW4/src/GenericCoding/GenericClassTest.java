package GenericCoding;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(1);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(1.3);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("This is Generic test class.");
        System.out.println(obj3.getObj());
    }
}
