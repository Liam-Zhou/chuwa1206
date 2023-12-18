package java8.features.lambda;

import java8.t00_common.pojos.Employee;
import java8.t00_common.utils.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

public class LambdaLearn {

    @Test
    public void overrideFoo() {
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
        Foo foo = parameter -> parameter + " from Foo";

        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase(Locale.ROOT) + " from Foo";

        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    // "Effectively Final", we can use the variable from outside when this variable is not changed
    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {return localVariable + " from Foo";};

        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    //
    @Test
    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };
        System.out.println(foo.aMethod("hello"));
    }


    // it gets error when we change the reference of the variable
    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL"; // 新的内存地址

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.aMethod("hello"));
    }

    // From this example, we can see that the local variable can not be changed after the lambda
    @Test
    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
            return parameter + " " + localVariable;
//            return parameter;
        };

//        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }

    // the employee can be regard as an "Effectively Final" variable
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
