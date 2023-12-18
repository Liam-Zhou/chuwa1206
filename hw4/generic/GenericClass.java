package hw4.generic;

public class GenericClass<T> {
    T obj;

    public GenericClass(T objc) {
        this.obj = objc;
    }

    public T getObj() {
        return this.obj;
    }
}
