package Java8_Features.optional;


import Java8_Features.pojos.Employee;
import org.testng.annotations.Test;

import java.util.Optional;


public class OptionalMainMethodTest {

    @Test()
    public void testOptionalWithNotHandleException() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @Test
    public void testOfNullable() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
    }

    @Test
    public void testOrElse() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        // remember type is not Optional, it is Employee
        Employee employee1 = Optional.ofNullable(employee).orElse(new Employee(1, "JCole", 30, 6666));
        if (employee != null) {
            employee1 = employee;
        } else {
            employee1 = new Employee(1, "JCole", 30, 6666);
        }
        System.out.println(employee1);
    }

    @Test
    public void testOrElseThrow() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        // remember type is not Optional, it is Employee
        Employee employee1 = Optional.ofNullable(employee).orElseThrow(() -> new RuntimeException("Wow Exception"));
        System.out.println(employee1);
    }
}