package java8.features.lambda;

import java8.common.pojps.Employee;
import java8.common.utils.EmployeeData;
import org.testng.annotations.Test;

import java.util.List;

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

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";

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
        localVariable = "LOCAL"; // 新的内存地址

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }

    //Object 的set方法不会报错
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



