import java.util.Objects;

public class Account {

    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return Double.compare(balance, account.balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
