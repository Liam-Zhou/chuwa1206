package hw2;

public class Q1 {
    //1. Encapsulation
    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age >= 0) {  // Validate age (encapsulation)
                this.age = age;
            } else {
                System.out.println("Invalid age. Age must be non-negative.");
            }
        }
    }

    //2. Polymorphism
    class Human {
        public void play(int game) {

        }
        //Static Polymorphism: overload
        public int play(int game, int instruments) {
            return 3;
        }
    }
    //Dynamic Polymorphism: Override
    class Father extends Human {
        public void play(int game) {
            System.out.println("Father palying");
        }
    }

    //3. Inheritance
    class Human2 {
        public void eat() {
            System.out.println("Father eat");
        }
    }

    class Son extends Human2 {
        public void eat() {
            System.out.println("Son eat");
        }
    }
}
