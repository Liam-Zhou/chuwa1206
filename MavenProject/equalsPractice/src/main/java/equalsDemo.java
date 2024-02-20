import java.io.File;
import java.util.Objects;

public class equalsDemo {
    public static void main(String[] args) {
        User u1 = new User("Tom",12);
        User u2 = new User("Tom",12);
        System.out.println(u1.equals(u2)); // true: override equals to compare content

        UserNoOverride u3 = new UserNoOverride("ABC", 10);
        UserNoOverride u4 = new UserNoOverride("ABC", 10);
        System.out.println(u3.equals(u4)); // false: no override and not the same reference

        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1==str2);  // true: string pool -> same reference

        String str3 = new String("Tom");
        String str4 = new String("Tom");
        System.out.println(str3 == str4); // false: different object
        System.out.println(str3.equals(str4)); // true: same content

        File file1 = new File("d://text");
        File file2 = new File("d://text");
        System.out.println(file1.equals(file2)); // true

        char charA = 'A';
        int int65 = 65;
        System.out.println(charA == int65); // true: same primitive value
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // generate by idea
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return Objects.equals(name, user.name);
    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
}

class UserNoOverride {
    String name;
    int age;

    public UserNoOverride(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
