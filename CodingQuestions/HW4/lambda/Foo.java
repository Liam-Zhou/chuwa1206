package lambda;

@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar() {
        String s = "Default Bar Method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "DefaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
