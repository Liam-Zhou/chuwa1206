import java.util.*;

public class OptionalDemo {
    public static void main(String[] args) {

        Optional<Member> optional = getMemberByIdFromDB();
        optional.ifPresent(mem -> {
            System.out.println("Membership name is：" + mem.getName());
        });
    }

    public static Optional<Member> getMemberByIdFromDB() {
        boolean hasName = true;
        if (hasName) {
            return Optional.of(new Member("123"));
        }
        return Optional.empty();
    }
}
class Member {
    private String name;

    public Member(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    // getter / setter
}
