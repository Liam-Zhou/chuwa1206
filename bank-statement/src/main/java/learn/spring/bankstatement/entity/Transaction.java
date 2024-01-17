package learn.spring.bankstatement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "transactions"
        /*
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        },
        indexes = {
                @Index(name = "idx_title", columnList = "title") // Index on 'title'
        }

         */
)
// specify details about the table that a JPA entity should be mapped to

@NoArgsConstructor
@Getter
@Setter
// @NamedQuery(name="Post.getAll", query="select p from Post p")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // rely on databases that support auto-increment columns (database automatically generates a unique value for each row when new records are inserted)
    private Long transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false)
    private Integer amount;



    @CreationTimestamp
    @Column(name = "create_date_time")
    // automatically managing the creation and last update timestamps of entity fields
    // When an entity is created and saved, Hibernate sets the annotated field with the current date and time
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time")
    // Whenever an entity is updated and saved, Hibernate updates the annotated field with the current date and time.
    private LocalDateTime updateDateTime;


    public Transaction(Account account, String description, Integer amount) {
        this.account = account;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionId +
                ", account=" + account +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
