package pattern.singleton;

public class Client {
    public static void main(String[] args) {
        // 创建Singletion类的对象
        EagerLoadSingletonDemo1 instance1 = EagerLoadSingletonDemo1.getInstance();
        EagerLoadSingletonDemo1 instance2 = EagerLoadSingletonDemo1.getInstance();

        System.out.println("Is the same object? ----> " + (instance1 == instance2));

        EagerLoadSingletonDemo2 instance3 = EagerLoadSingletonDemo2.getInstance();
        EagerLoadSingletonDemo2 instance4 = EagerLoadSingletonDemo2.getInstance();

        System.out.println("Is the same object? ----> " + (instance3 == instance4));

        LazyLoadSingletonDemo1 instance5 = LazyLoadSingletonDemo1.getInstanceThreadUnsafe();
        LazyLoadSingletonDemo1 instance6 = LazyLoadSingletonDemo1.getInstanceThreadSafe();

        System.out.println("Is the same object? ----> " + (instance5 == instance6));

        EagerLoadSingletonDemo3 instance7 = EagerLoadSingletonDemo3.INSTANCE;
        EagerLoadSingletonDemo3 instance8 = EagerLoadSingletonDemo3.INSTANCE;

        System.out.println("Is the same object? ----> " + (instance7 == instance8));
    }
}
