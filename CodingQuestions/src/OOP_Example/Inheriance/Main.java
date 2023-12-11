package OOP_Example.Inheriance;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Nguyen Van A", 30, 233);
        teacher.eat();
        teacher.sleep();
        teacher.teach();
        teacher.grade();
        //the following line will cause error because teacher didn't implement doHW() method
        //teacher.doHW();
        Student student = new Student("Nguyen Van B", 20, 123);
        student.eat();
        student.sleep();
        student.study();
        student.doHW();
    }
}
