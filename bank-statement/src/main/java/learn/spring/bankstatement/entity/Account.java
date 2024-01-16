package learn.spring.bankstatement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "accounts"
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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // rely on databases that support auto-increment columns (database automatically generates a unique value for each row when new records are inserted)
    private Long accountId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "routing_number", nullable = false)
    private String routingNumber;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();


    @CreationTimestamp
    @Column(name = "create_date_time")
    // automatically managing the creation and last update timestamps of entity fields
    // When an entity is created and saved, Hibernate sets the annotated field with the current date and time
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time")
    // Whenever an entity is updated and saved, Hibernate updates the annotated field with the current date and time.
    private LocalDateTime updateDateTime;


    public Account(User user, String routingNumber, String accountNumber) {
        this.user = user;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", routingNumber='" + routingNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", tansactions=" + transactions +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
