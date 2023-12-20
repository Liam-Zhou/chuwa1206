package GenericCoding;

public class GenericMultiArguments {
    public static void main(String[] args) {
        temp(1, 1.2, "Generic");
    }
    public static <T1, T2, T3> void temp (T1 x, T2 y, T3 z) {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
