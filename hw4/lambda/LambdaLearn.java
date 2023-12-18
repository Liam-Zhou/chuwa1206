package hw4.lambda;

import org.junit.Test;

public class LambdaLearn {
    @Test
    public void overrideFoo() {
        //creating an anonymous class that implements the Foo interface
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

    /**
     * Use “Effectively Final” Variables
     * 当variable只赋值一次，没有任何变动的时候，Java默认是final。
     * 注意，在lambda expression的前后都不能被改变
     */
    @Test
    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    /**
     * 换object会报错，因为换了内存地址
     */
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

    /**
     * Object 的set方法不会报错
     */
    @Test
    public void testFinal3() {
//        List<Employee> employees = EmployeeData.getEmployees();
//
//        Employee employee = employees.get(0);
//        employee.setAge(55);
//        Foo foo = parameter -> {
//            return parameter + " " + employee;
//        };
//
//        System.out.println(foo.aMethod("hello"));
    }


}
