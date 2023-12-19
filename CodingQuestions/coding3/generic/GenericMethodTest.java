package coding3.generic;

public class GenericMethodTest {
    public static void main(String[] args) {
        int a = 2;
        double b = 2.2;
        Long c = 1L;
//        String b = "3"; String会报错.
        print(a);
        print(b);
        print(c);

    }
    public static <T extends Number> void print(T val) { //定义泛型方法, 上界, 只有 number 或者number的子类才可以
        System.out.println(val);
    }
}
