# HW4

## Q1. Generic Class

Generic allows using different data type in the same template. Thus the code can be easily reused without duplication



## Q2-4 

coding questions



## Q5. Write the Singleton design pattern include eager load and lazy load.

``` java
public class EagerLoad{
    private static EagerLoad instance = new EagerLoad();
    
    private EagerLoad(){
    }
    
    public static EagerLoad getInstance(){
        return instance;
    }
}

public class LazyLoad{
    private LazyLoad(){
    }
    
    private static class SingletonHolder{
        private static final Singleton instance = new LazyLoad();
    }
    public static LazyLoad getInstance(){
        return SingletonHolder.instance;
    }
}
```



## Q6. What is Runtime Exception? could you give me some examples?

Unchecked Exception - Runtime Exception

- NullPointerException
- IndexOutOfBoundException



## Q7. Could you give me one example of NullPointerException?

When a variable expect a function expect return value of type <Item> but the function returns null.



## Q8. What is the Optional class?

It is an effective way to handle possible null pointer together with normal values. Thus reduce the likelihood that NPE happens.



## Q9. What are the advantages of using the Optional class?

- reduce NPE
- simply code by not using try catch blocks
- Explictly claim a value as possibly null, make the code clear
- Many useful helper functions like filter, map, and can be chained



## Q10.What is the @FunctionalInterface?

This is an annotation indicating this interface is functional interface, which contains only one abstract method (SAM single abstract method)



## Q11. what is lambda?

Lambda is a simplified method to substitute annoumous inner class. And it is often used to be an implementation of functional interface.



## Q12. What is Method Reference?

It use to refer to a function, and allows a function to be passed as an argument or variable. Typical usage like

```
Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge)
```



## Q13. What is Java 8 new features?

- Lambda 
- Functional Interface
- Stream
- Default keyword
- Method reference



## Q14. Lambda can use unchanged variable outside of lambda? what is the details?

Lambda can access outer variables, but that variables should be final or used as effective final, i.e. cannot be reassigned BEFORE and AFTER lambda blocks. The reason why cannot reassign after lambda blocks is that lambda may be run in other threads or in delayed time.



## Q15. Describe the newly added features in Java 8?

Q13



## Q16. Can a functional interface extend/inherit another interface?

Yes. It may happens when base interface do not contains abstract function, or inheritated class add default or static method. The baseline is the interface has only one SAM from all sources.



## Q17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
Lambda is an easy way to create an instance of a functional interface



## Q18. In Java 8, what is Method Reference?

Q12



## Q19. What does the String::ValueOf expression mean?

convert other type to string



## Q20. What are Intermediate and Terminal operations?

Intermediate

     * 一，筛选
     * 1. filter(Predicate p) - 接受lambda, 从流中排出某些元素
     * 2. limit(n) - 截断流，使其元素不超过给定的数量
     * 3. skip(n) - 跳过前n个元素
     * 4. distinct() - 筛选，通过元素的hashcode(), equals()去除重复元素
     * <p>
     * 二，映射
     * 1, map(function f) element -> black box(f) -> new element
     * 2, flatMap(function f)
     * 三， 排序
     * 1, sorted



Termination

     * 一， 匹配与查找
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     * 9, forEach(Consumer c) - 内部迭代
     * <p>
     * 二，归约
     * 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * <p>
     * 三， 收集
     * 1, collect(Collector c)



## Q21. What are the most commonly used Intermediate operations?

map and filter



## Q22. What is the difference between findFirst() and findAny()?

findFirst returns the first element of the stream

findany returns any element of the stream without any specific guarantee about the encounter order



## Q23. How are Collections different from Stream?

Collection is used for store, and stream is used for processing.