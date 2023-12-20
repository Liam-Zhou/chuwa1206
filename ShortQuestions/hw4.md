### Q1
Generic refers to a feature that allows classes and methods to operate on objects of various types while providing compile-time type safety
- Type Safety
  - Generics provide compile-time type checking, reducing the likelihood of runtime errors related to type mismatches
- Reusability
  - Generic classes and methods can be used with different data types, promoting code flexibility and reducing redundancy
- Collections Framework
  - It uses generics to create type-safe collections like `ArrayList<E>`, `HashMap<K, V>`
- Eradicate Type Casting
  - Generics help eliminate the need for explicit type casting when working with objects, making code cleaner and less error-prone
- Compile-time benefits
  - Errors related to type mismatches are detected at compile time, providing early feedback and improving code robustness
### Q2
CodingQ
### Q3
CodingQ
### Q4
CodingQ
### Q5
- Eager Load
```
private Singleton() {

}

private static Singleton instance = new Singleton();

public static Singleton get.instance() {
    return instance;
}
```
- Lazy Load
```
private Singleton() {

}

static {
    // do something
}

private static class SingletonHolder {
    private static final Singleton INSTANCE = new Singleton();
}

public static Singleton getInstance() {
    return SingletonHolder.INSTANCE;
}
```
### Q6
- Also known as Unchecked exception that occurs during the execution of a program at runtime. These exceptions can lead to abnormal program termination if they are not handled properly.
- Examples
    - ArithmeticException
    - NullPointerException
    - ArrayIndexOutOfBoundException
    - NumberFormatException
### Q7
**NullPointerException** occurs when you try to access a method on an object reference that is '_null_'
```
public static void main(String[] args) {
    String str = null;
    
    try {
        int length = str.length();
    } catch(NullPointerException e) {
        sout("NullPointerException: " + e.getMessage());
    }
}
```
### Q8
Optional class is a container object which can contain a null value. It can help writing a neat code w/o using too many null check.
### Q9
To avoid null checks and run time NullPointerException, a safer way to handle potentially null values and make the code more concise and readable.
### Q10
For sanity check
### Q11
To replace anonymous inner class, and work with functional interface
### Q12
Method reference is used to directly access existing methods or constructors of a class or instance. It provides a way to reference a method w/o executing it, requiring a context of a compatible functional interface. During computation, a method reference creates an instance of the functional interface.

| Type                                | Example                                |
|-------------------------------------|----------------------------------------|
| Static Method                       | `ContainingClass::staticMethodName`    |
| Object's instance Method            | `ContainingObject::instanceMethodName` |
| Anytype of object's instance Method | `ContainingType::methodName`           |
| Constructor                         | `ClassName::new`                       |
| ArrayType::new                      | `ArrayType::new`                       |
### Q13
- Lambda Expression
- Functional Interface
- Method Reference
- StreamAPI
- Optional
- Default Method
- Date time API
### Q14
Yes, as long as the memory address of the variable doesn't change
- final variable
- non-final variable however never changed
- object variable (if we use new to reassign a new memory, then this variable is changed, cannot be used in lambda)
### Q15
- Lambda Expression: a function that can be shared or referred to as an object
- Functional Interface: single abstract method interface
- Method Reference: uses function as a parameter to invoke a method
- Default Method: it provides an implementation of methods w/in interfaces enabling 'Interface evolution' facilities
- StreamAPI: abstract layer that provides pipeline processing of the data
- Date time API: new improved joda-time inspired APIs to overcome the drawbacks in previous versions
- Optional: Wrapper class to check the null values and help in further processing based on the value
### Q16
Yes, however it can only have one single abstract method, a lot of default method
### Q17
- Lambda Expression
  - A concise way to represent an anonymous function in Java
  - `(parameters) -> expression` 
  or
  - `(parameters) -> {statements;}`
- Lambda and functional interface
  - Lambda expression can be used to provide a more compact implementation of the single abstract method in a functional interface
  - parameter and return type of the lambda expression must match those of the functional interface's abstract method
  - enables a more concise syntax for working with single-method interfaces
### Q18
Method reference is used to directly access existing methods or constructors of a class or instance. It provides a way to reference a method w/o executing it, requiring a context of a compatible functional interface. During computation, a method reference creates an instance of the functional interface.

| Type                                | Example                                |
|-------------------------------------|----------------------------------------|
| Static Method                       | `ContainingClass::staticMethodName`    |
| Object's instance Method            | `ContainingObject::instanceMethodName` |
| Anytype of object's instance Method | `ContainingType::methodName`           |
| Constructor                         | `ClassName::new`                       |
| ArrayType::new                      | `ArrayType::new`                       |
### Q19
It's a shorthand of `(number) -> String.valueOf(number)`, is a method reference that refers to the static `valueOf` method in the `String` class
### Q20
- Intermediate operation: processing data, such as filter and map
- Terminate operation: searching data, and once the terminate operation is raised, the stream pipeline will be terminated
### Q21
- filter
```
filter(Predicate p) - 接受lambda，从stream中排出某些元素
limit(n) - 截断，使其元素不超过给定的数量
skip(n) - 跳过前n个元素
distinct() - 筛选，通过元素的hashcode(), equals()除去重复元素
```
- map
```
map(function f) element -> black box(f) -> return new element
flatMap(function f)
```
- sort
### Q22
- findFirst: return the very first element
- findAny: return any element from the stream
### Q23
| Collection                                | Stream                                                                                   |
|-------------------------------------------|------------------------------------------------------------------------------------------|
| data structure holds all the data element | no data is stored. Have the capacity to process an infinite number of elements on demand |
| external iteration                        | internal iteration                                                                       |
| can be processed any number of time       | traversed only once                                                                      |
| elements are easy to access               | no direct way of accessing specific elements                                             |
| is a data store                           | is an API to process the data                                                            |
