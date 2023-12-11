package OOP_Example.Encapsulation;

class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, int age, String address, String phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void eat(String foodname) {
        System.out.println("Person is eating " + foodname);
    }

    public String toString() {
        String result = "Name: " + name + " Age: " + age + " Address: " + address + " Phone Number: " + phoneNumber + " Email: " + email;
        return result;
    }
}
