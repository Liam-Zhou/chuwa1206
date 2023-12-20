package coding3.t06_java8.features.lambda;
@FunctionalInterface
public interface Foo {
    abstract String aMethod(String s);

    default  String defaultBar() {
        String s = "default bar method";
        System.out.println(s);
        return s;
    }
    default  String defaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
