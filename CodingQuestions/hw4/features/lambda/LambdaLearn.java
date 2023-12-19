package hw4.features.lambda;

import hw4.common.pojos.Employee;
import hw4.common.utils.EmployeeData;
import org.junit.Test;

import java.util.List;

/**
 * @program: CodingQuestions
 * @ClassName LambdaLearn
 * @description:
 * @author: Zhenwei Dai
 **/
public class LambdaLearn {
    @Test
    public void overrideFoo(){
        Foo fooByIc = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + " from foo";
            }
        };

        String hello = fooByIc.aMethod("hello");

        System.out.println(hello);
    }
    @Test
    public void lambdaFoo(){
        Foo  foo = parameter -> parameter + " from foo";
        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }
    @Test
    public void lambdaFoo2(){
        Foo foo = parameter ->{
            return parameter+" from foo";
        };
        System.out.println(foo.aMethod("hello"));
    }
    @Test
    public void testFinal(){
        final String local = "Local";
        Foo foo = parameter -> parameter + " " + local;
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testEffectivelyFinal(){
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal21(){
        String localVariable = "Local";
        localVariable = "LOCAL"; // address change here

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

        localVariable = "LOCAL"; // address change here

        System.out.println(foo.aMethod("hello"));
    }
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