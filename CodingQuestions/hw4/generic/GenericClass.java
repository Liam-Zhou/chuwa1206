package hw4.generic;

/**
 * @program: CodingQuestions
 * @ClassName GenericClass
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-18 15:05
 * @Version 1.0
 **/
public class GenericClass<T> {
    T obj;

    public GenericClass(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }
}