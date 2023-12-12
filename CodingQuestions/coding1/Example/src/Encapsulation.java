public class Encapsulation {
    public static void main(String[] args) {
        /*
            Encapsulation package the attributes and behavior of an abstract thing into a class,
            and use access modifier to manage the access control.

            public: can be accessed by all
            protected: can be accessed by the class in the same package and its subclasses
            default: can be accessed within the same package
            private: can only be accessed by  in its class
            m
         */

        // Encapsulation
        // we use the getter and setter function to access the private attributes
        Animal animal = new Animal("Tom", 18, "cat");
        System.out.println(animal.getName());
        animal.setName("Jelly");
        System.out.println(animal.getName());
    }
}
class Animal {
    private String name;
    private Integer age;
    private String species;

    public Animal(String name, Integer age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
