package features.default_interface_method;

interface DIML {
    static final String BLOG = "is CHwa a";

    int add(int a, int b);


    // 可以增加一个实现了的Default函数
    default int substract(int a, int b) {
        return a - b;
    }
    // 可以增加一个实现了的静态函数，直接通过类名进行调用
    static String blogName() {
        return BLOG;
    }
}

class DIMImpl implements DIML{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

}

class Client {
    public static void main(String[] args) {
        DIML dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());

    }
}
