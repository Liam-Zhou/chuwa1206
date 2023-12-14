# Hanyun Zhao HW3

##  Q1.coding



## Q2. What is the checked exception and unchecked exception in Java, could you give one example?

checked exception: happen before runtime, will be checked during compiling or earlier. e.g. IOException， SQLException

unchecked exceptions: runtime exception. e.g. NullPointerException, IndexOutOfBoundsException



## Q3. Can there be multiple finally blocks?

No. Finally block is executed after try or catch is done, and before return happens. As the name goes, finally block is the last one in the block.



## Q4. When both catch and finally return values, what will be the final result?

The return in finally block will be the final result.



## Q5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- Checked exceptions represent errors outside the control of the program (e.g., file not found, network errors). The programmer is forced to consider these exceptional conditions and handle them appropriately.
- Unchecked exceptions represent problems that are the result of a programming error (e.g., null pointer access). They are usually bugs that should be fixed in the code rather than being merely handled.



## Q6. What is the difference between throw and throws?

Throw is used when raising an exception, and throws is used in function signature to declare that this function may throw these kinds of exceptions.



## Q7. Run code

Because exception catch scope should go from small to large. 



## Q8. What is optional? why do you use it? write an optional example.

Optional is used to simplify null check and avoid NPE.

```java
T optobj = Optional.ofNullable(value)
							.orElse(Tdefaultvalue)
```



## Q9. Why finally always be executed ?

Becuase it is designed to do clean up no matter exceptions happend or not.



## Q10. What are the types of design patterns in Java ?

- aggregation: the lifetime of the owned object does not depend on the lifetime of the owner
- composition: ...depend on the ...
- singleton: The class has only one object among all time



## Q11. What are the SOLID Principles ?

- S - singleton
- O -Open/Closed Principle : Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. This means that the behavior of a module can be extended without modifying its source code.
- L - Liskov Substitution Principle: Objects in a program should be replaceable with instances of their subtypes without altering the correctness of the program. Simply put, subclasses should be substitutable for their base classes.
- I - Interface Segregation Principle: Many client-specific interfaces are better than one general-purpose interface. No client should be forced to depend on methods it does not use.
- D - Dependency Inversion Principle: Depend upon abstractions, not concretions. High-level modules should not depend on low-level modules; both should depend on abstractions. 



## Q12. How can you achieve thread-safe singleton patterns in Java ?

``` java
public class EagerLoad {
    private static EagerLoad instance = new EagerLoad();

    private EagerLoad(){
    }

    public static EagerLoad getInstance(){
        return instance;
    }
}

public class LazyLoad {
    private LazyLoad(){

    }

    private static class holder{
        private static final LazyLoad instance = new LazyLoad();
    }

    public static LazyLoad getInstance(){
        return holder.instance;
    }
}
```



## Q13. What do you understand by the Open-Closed Principle (OCP)

1. open for extension: the current functionality should be able to extended 
2. closed for modification: the module update or extension should be able to achieve withouot changing current code.



## Q14. multiple choice

A or C ?

(gpt4 choose C. I'm not sure)



## Q15.  Design pattern

In /MavenProject

 

