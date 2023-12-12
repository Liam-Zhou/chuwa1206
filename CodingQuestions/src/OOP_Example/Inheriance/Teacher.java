package OOP_Example.Inheriance;

public class Teacher extends Person implements Grading {
    int teacherID;
    @Override
    public void grade() {
        System.out.println("Teacher is grading");
    }
    // the own method of Teacher
    public void teach() {
        System.out.println("Teacher is teaching");
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int teacherID) {
        super(name, age);
        this.teacherID = teacherID;
    }

    public void eat() {
        System.out.println("Teacher is eating");
    }

    public void sleep() {
        System.out.println("Teacher is sleeping");
    }
}
