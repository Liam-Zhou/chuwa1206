package lambda;

import com.chuwa.tutorial.t00_common.pojos.Employee;
import com.chuwa.tutorial.t00_common.utils.EmployeeData;
import org.junit.Test;

import java.util.List;
public class LambdaLearn {
    /**
     * Before Java8, using Anonymous Class to override this method
     * Interface var = new Class
     *
     */
    public void overrideFoo() {
        Foo fooByIc = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + "from Foo";
            }
        };

        String hello = fooByIc.aMethod("hello");
        System.out.println(hello);
    }

    public void lambdaFoo() {
        /**
         * aMethod() abstract method, missing the method body, lambda can provide it
         */
        Foo foo = parameter -> parameter + "from Foo";

        String hello = foo.aMethod("HELLO");
        System.out.println(hello);
    }

    public void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase() + "from Foo";

        String hello = foo.aMethod("hi");
        System.out.println(hello);
    }

    public void testFinal() {
        final String localVariable = "Local";

        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    public void testEffectivelyFinal() {
        /**
         * "Effectively Final": 当variable只赋值一次，之后没有任何变动时，Java默认是final
         * 注意！variable必须在lambda前后都不改变
         */
        String localVariable = "Local";

        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    public void testFinal2() {
        /**
         * 在lambda之前换object会报错，因为换了内存地址
         */
        String localVariable = "Local";
        localVariable = "Local";

        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    public void testFinal3() {
        /**
         * object在lambda之后换也会报错
         */
        String localVariable = "local";

        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        localVariable = "LocaL";

        System.out.println(foo.aMethod("hello"));
    }

    public void testFinal4() {
        /**
         * Object用 setAge()方法进行年龄更改不会报错
         */
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55);

        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }
}
