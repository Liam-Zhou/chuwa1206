package OOP_Example.Inheriance;

public class Student extends Person implements DoingHW{
    int studentID;
    @Override
    public void doHW() {
        System.out.println("Student is doing homework");
    }
    // the own method of Student
    public void study() {
        System.out.println("Student is studying");
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, int studentID) {
        super(name, age);
        this.studentID = studentID;
    }

    public void eat() {
        System.out.println("Student is eating");
    }

    public void sleep() {
        System.out.println("Student is sleeping");
    }
}
