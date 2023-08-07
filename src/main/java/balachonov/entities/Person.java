package balachonov.entities;

import balachonov.enums.PersonRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

import static balachonov.util.Constants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = PERSONS)
@Where(clause = DELETED_ZERO)
public class Person {

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID,
            strategy = UUID_STRATEGY)
    @Column(name = PERSON_ID, unique = true,
            updatable = false, nullable = false)
    private String id;

    @Column(name = FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = EMAIL, unique = true, nullable = false)
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = PERSON_ADDRESS,
            joinColumns = @JoinColumn(name = PERSON_ID),
            inverseJoinColumns = @JoinColumn(name = ADDRESS_ID))
    private List<Address> addresses;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @Column(name = SALT, nullable = false)
    private String salt;

    @Enumerated(EnumType.STRING)
    @Column(name = ROLE, nullable = false)
    private PersonRole role;

    @OneToMany(mappedBy = BASKET,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Basket> orders;

    @Column(name = DELETED)
    private Integer deleted = 0;

    public void setDeleted() {
        this.deleted = 1;
    }
}
