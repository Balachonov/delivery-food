package balachonov.entities;

import balachonov.enums.PersonRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.*;
import static jakarta.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = PERSONS)
@Where(clause = DELETED_ZERO)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = PERSON_ID, unique = true,
            updatable = false)
    private UUID id;

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = EMAIL, unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = PERSON_ADDRESS,
            joinColumns = @JoinColumn(name = PERSON_ID),
            inverseJoinColumns = @JoinColumn(name = ADDRESS_ID))
    private List<Address> addresses;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = SALT)
    private String salt;

    @Enumerated(STRING)
    @Column(name = ROLE)
    private PersonRole role;

    @OneToMany(mappedBy = PERSON,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Basket> baskets;

    @Column(name = DELETED)
    private Integer deleted = 0;

    public void setDeleted() {
        this.deleted = 1;
    }
}
