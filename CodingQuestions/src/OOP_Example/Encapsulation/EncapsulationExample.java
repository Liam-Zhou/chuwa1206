package OOP_Example.Encapsulation;

public class EncapsulationExample {
    public static void main(String[] args) {
        Person person1 = new Person("John", 20, "123 Main St", "123-456-7890", "1234564@qq.com");
        Person person2 = new Person();
        person2.setAddress("456 Main St");
        person2.setAge(30);
        person2.setEmail("2314355@gmail.com");
        person2.setName("Mary");
        person2.setPhoneNumber("123-456-7890");
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.toString());

        person1.eat("apple");
        person2.eat("banana");

        //the following line will not work because name is private and can only be accessed within the Person class(Encapsulation
        //System.out.println(person2.name);
    }

}

