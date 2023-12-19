package hw23.geneics;

public class GenericClass <T>{
    private T obj;

    public GenericClass(T o){
        this.obj=o;
    }

    public T getObj() {
        return obj;
    }
}
