package generic;
public class GenericClassTest {

    public static void main(String[] args) {
        // Test for Integer type
        GenericClass<Integer> obj1 = new GenericClass<>(100);
        System.out.println(obj1.getObj());

        // Test for double type
        GenericClass<Double> obj2 = new GenericClass<>(3.1415926);
        System.out.println(obj2.getObj());

        // Test for String type
        GenericClass<String> obj3 = new GenericClass<>("123456");
        System.out.println(obj3.getObj());
    }
}
