package learn.spring.bankstatement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
        name = "users",

        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"phone"}),
                @UniqueConstraint(columnNames = {"email"})
        }
        /*
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // rely on databases that support auto-increment columns (database automatically generates a unique value for each row when new records are inserted)
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // all persistence operations (such as persist, remove, refresh, merge, detach) that happen to the ONE entity will also be applied to the associated MANY entities.
    //For example, if a Post is removed, all its associated Comment entities will also be removed from the database.

    // dependent objects (children) that should no longer exist when they're no longer referenced by their parent object.
    // any Account that is removed from the accounts collection will be automatically removed from the database.
    private Set<Account> accounts = new HashSet<>();


    @CreationTimestamp
    @Column(name = "create_date_time")
    // automatically managing the creation and last update timestamps of entity fields
    // When an entity is created and saved, Hibernate sets the annotated field with the current date and time
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time")
    // Whenever an entity is updated and saved, Hibernate updates the annotated field with the current date and time.
    private LocalDateTime updateDateTime;


    public User(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
