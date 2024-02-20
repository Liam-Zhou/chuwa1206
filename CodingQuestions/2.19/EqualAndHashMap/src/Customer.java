import java.util.Objects;

public class Customer {
    private String name;
    private int age;
    private Account account;

    public Customer() {
    }

    public Customer(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
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
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Customer customer = (Customer) object;
        return age == customer.age && Objects.equals(name, customer.name) && Objects.equals(account, customer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, account);
    }
}
