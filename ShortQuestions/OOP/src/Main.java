
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
    public Pig(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("The dog says: bow wow");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("animal");  // Create a Animal object
        Animal pig = new Pig("pig");  // Create a Pig object
        Animal dog = new Dog("dog");  // Create a Dog object
        animal.speak();
        pig.speak();
        dog.speak();

        System.out.println(animal.getName());
        System.out.println(pig.getName());
        System.out.println(dog.getName());
    }
}