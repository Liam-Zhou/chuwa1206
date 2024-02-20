import java.util.Objects;

public class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof User user) {
            return this.age == user.age && this.name.equals(user.name);
        }
        return false;
    }
}
