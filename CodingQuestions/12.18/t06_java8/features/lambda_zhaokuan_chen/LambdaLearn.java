package com.chuwa.tutorial.t06_java8.features.lambda_zhaokuan_chen;

import com.chuwa.tutorial.t00_common.pojos.Employee;
import com.chuwa.tutorial.t00_common.utils.EmployeeData;
import org.junit.Test;

import java.util.List;

public class LambdaLearn {

    @Test
    public void overrideFoo() {
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String str) {
                return str + " From Foo";
            }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        Foo foo = str -> str + " From Foo";
        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        Foo foo = str -> str.toUpperCase() + " From Foo";
        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = str -> {
            return str + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testEffectiveFinal() {
        String localVariable = "Local";
        Foo foo = str -> str + " " + localVariable;
        System.out.println(foo.aMethod("Hello"));
    }

    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL";

        com.chuwa.tutorial.t06_java8.features.lambda.Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";


        com.chuwa.tutorial.t06_java8.features.lambda.Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(100);
        com.chuwa.tutorial.t06_java8.features.lambda.Foo foo = parameter ->
                parameter + " " + employee;

        System.out.println(foo.aMethod("hello"));
    }

}
