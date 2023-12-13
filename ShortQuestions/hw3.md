# 1. Practice collection

done.

# 2. What is the checked exception and unchecked exception in Java, could you give one example?

Checked exceptions are exceptions that the compiler requires you to handle explicitly. Some examples would be IOException, and SQLException.

Unchecked exceptions are exceptions that are not checked at compile time, you are not required to catch the unchecked exceptions, but it's a good practice to handle them to avoid unexpected program termination.
Some examples would be ArithmeticException and ArrayIndexOutOfBoundsException.

# 3. Can there be multiple finally blocks?

No, there can't be multiple `finally` blocks.

# 4. When both catch and finally return values, what will be the final result?

The value returned by the 'finally' block will be the one that is ultimately returned by the method because the 'finally' block is always executed no matter if there is a catch or not, so it overrides the previous return value.

# 5. What is a Runtime/unchecked exception? what is a Compile/Checked Exception?

Compile-time/checked exceptions are exceptions that the Java compiler forces you to handle explicitly, they are checked at compile time, and if you don't catch or declare them using the 'throws' clause, the code will not compile.

Runtime/unchecked exceptions are exceptions that are not checked at compile time. The compiler does not require you to catch or declare them, but it's better to handle those as well to prevent unexpected program termination.

# 6. What is the difference between throw and throws?

The `throw` is used to explicitly throw an exception in the code, it is followed by an instance of 'Throwable' that you want to throw.

The `throw` keyword is used in the method declaration to indicate that the method may throw certain types of exceptions. it is followed by a list of exception classes that the method might throw. When a caller calls those methods, it's the caller's responsibility to handle those exceptions, the caller can either catch the exceptions or pass the responsibility further up the call stack.

# 7. Run the below three pieces of code. Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
}
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
e.printStackTrace();} catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
}
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
}
        System.out.println("End ...");
    }
}

```

after running the 3 pieces of code, I found that the order of the catch block for each exception matters a lot, in the first example, the arithmetic exception is caught because it's more specific and can be caught by ArithmetirException, the second code means that the nullpointerexception catch block becomes the most specific catch block. 3. the third one is similar, because the runtimeexception is more specific so it can be caught by the runtimeexception catch block, instead of the Exception catch block.

In summary, the order matters, if we put the Exception catch block in the first, then the rest of the less specific Exception catch block will have no chance to catch anymore.

# 7. What is optional? why do you use it? write an optional example.

we used optional to handle the possibly null value to avoid error.
for example

`
public class OptionalExample {

    public static void main(String[] args) {
        // a non-null value
        String value = "Hello"
        Optional<String> presentOptional = Optional.of(value);

        // a potentially null value
        String nullableValue = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

        // empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Using Optional to handle potential null values
        System.out.println(getLength(presentOptional));  // Output: Length is 5
        System.out.println(getLength(nullableOptional)); // Output: Length is 0
        System.out.println(getLength(emptyOptional));     // Output: Length is 0
    }

    // if we don't use Optional class to wrap the values, some null values can cause run-time errors.
    private static String getLength(Optional<String> optional) {
        // Using lambda map to transform the value if present
        return optional.map(value -> "Length is " + value.length())
                       .orElse("Length is 0"); // Providing a default value if the optional is empty
    }

}

`

# 8. Why finally always executed?

it's designed this way by Java, and there are some reasons why the `finally` should always be executed:

1. it closes up or releases all the resources or performs cleanup operations.
2. the `finally` block runs before the exception is propagated up the call stack if an exception is thrown.

# 9. Practice collection problems here

done.

# 10. What are the types of design patterns in Java?

There are commonly 3 types of design patterns in Java: Creational Design patterns, for example, singleton and factory patterns; Structural Design patterns, for example, decorate patterns; Behavioral Design patterns, for example, observer patterns.

# 11. What are the **SOLID** principles?

S for single Responsibility Principle.
O for Open/closed principle.
L for Liskov substitution principle.
I for Interface segregation principle.
D for Dependency inversion principle.

# 12. How can you achieve thread-safe singleton patterns in Java?

it can be done via eager initialization or lazy but with double-checked locking, or the static inner class way to achieve a thread-safe singleton.

# 13. What do you understand by the Open-Closed Principle (OCP)?

The original definition for this is "Software entities(such as classes, modules, methods, and functions) should be open for extension but closed for modification."

from my own understanding, it suggests a way to extend better than modify to avoid possible bugs or breaking existing functionality, to increase the decoupling.

# 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing
2. It means that all the objects of type A could
   execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute the object of type A.
4. It means that for class B to inherit class A, objects of type B and objects of type A must be the same.

choice 3 is the correct one, it means if a method is present in Class A, we can make the methods present in Class B so that B can do all the things that A can do.

# 15. Watch the design pattern video, and type the code, submit it to Maven Project folder

done.
