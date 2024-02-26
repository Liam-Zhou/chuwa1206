import java.util.Objects;

public class Employee {
    private Integer id;
    private String name;
    private String department;

    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }


    @Override
    public int hashCode() {
       int result = 17;
       result = 31 * result + id.hashCode();
        //result = 31 * result + name.hashCode(); if name is needed for hashcode
        // result = 31 * result + department.hashCode(); if department is needed for hashcode
       return result;
    }
}
