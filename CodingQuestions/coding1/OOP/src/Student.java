public class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void action() {
        System.out.println(this.getName() + " is studying.");
    }
}
