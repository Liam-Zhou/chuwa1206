package tutorial.t06_java8.features.lambda;

import org.junit.Test;
import tutorial.t00_common.Employee;
import tutorial.t00_common.EmployeeData;

import java.util.List;

public class LambdaLearn {
    /*

      https://www.baeldung.com/java-8-lambda-expressions-tips

      1， 只能有一个方法。可以有多个default方法（因为default方法被实现了）
      2， Avoid Overloading Methods With Functional Interfaces as Parameters， 如果有overloading, 可以用Cast

      By using the @FunctionalInterface annotation, the compiler will trigger an error in response to any attempt to
      break the predefined structure of a functional interface. It is also a very handy tool to make our application
      architecture easier to understand for other developers.
     */
    @Test
    public void overrideFoo() {
        // before Java 8, we use Anonymous Class to override this method
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + " from Foo";
            }
        };
        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        // Foo.aMethod() 是abstract method 缺少method body，由lambda提供
        Foo foo = parameter -> parameter + " from foo";
        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase() + " from foo";
        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL";
        Foo foo = parameter -> {
            // java: local variables referenced from a lambda expression must be final or effectively final
            // parameter = parameter + " " + localVariable;
            return parameter;
        };
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            // parameter = paramter + " " + localVariable;
            return parameter;
        };
        // need to be unchanged in the block
        localVariable = "LOCAL";
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }
}
