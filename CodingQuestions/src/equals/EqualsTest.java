package equals;

import java.util.Objects;

public class EqualsTest {
    public static void main(String[] args) {
        User u1=new User("John Dow","test");
        User u2=new User("John Dow","test");
        System.out.println(u1.equals(u2));
    }

}

class User{
    private String name;
    private String address;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        return Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
