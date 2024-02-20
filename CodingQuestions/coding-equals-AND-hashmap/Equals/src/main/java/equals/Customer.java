package equals;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.lang.model.element.AnnotationValueVisitor;
import java.util.Objects;

/**
 * @author Alex D.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private int age;
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name) && Objects.equals(account, customer.account);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, account);
//    }
}
