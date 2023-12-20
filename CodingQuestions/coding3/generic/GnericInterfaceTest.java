package coding3.generic;

interface Info<T> {        // 在接口上定义泛型
    public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型
}

class InfoImpl<T> implements Info {
    private T var;

    public InfoImpl(T var) {
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }
}

public class GnericInterfaceTest {
    public static void main(String arsg[]) {
        Info<String> i = new InfoImpl<String>("chuwa");
        System.out.println(i.getVar());
    }
}
