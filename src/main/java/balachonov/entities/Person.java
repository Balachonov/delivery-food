package balachonov.entities;

import balachonov.enums.PersonRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.*;
import static jakarta.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Accessors(chain = true)
@Table(name = PERSONS)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = PERSON_ID,
            updatable = false)
    private UUID id;

    @Column(name = FIRST_NAME,
            nullable = false,
            length = 20)
    private String firstName;

    @Column(name = LAST_NAME,
            nullable = false,
            length = 20)
    private String lastName;

    @Column(name = EMAIL,
            unique = true,
            nullable = false)
    private String email;

    @Column(name = TELEPHONE,
            nullable = false)
    private String telephone;

    @Column(name = PASSWORD,
            nullable = false)
    private String password;

    @Enumerated(STRING)
    @Column(name = ROLE,
            nullable = false)
    private PersonRole role;

    @OneToMany(mappedBy = PERSON,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Order> orders;
}