package coding3.t06_java8.features.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author b1go
 * @date 4/11/23 11:57 PM
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("A", new Address("Fifth ave")));
        userMap.put(2, new User("B", null));

        //不用 optional 代码非常繁琐. 要check user是不是null, 然后再check address是不是null, 用option就会优雅许多
        String streatName = "";
        User u1 = userMap.get(2);
        streatName = Optional.ofNullable(userMap.get(1))
                .map(user -> user.getAddress())
                .map(Address :: getStreet)
                .orElse("there is no street address");
        System.out.println(streatName);
    }
}

class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
