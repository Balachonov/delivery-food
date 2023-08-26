package balachonov.entities;

import balachonov.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.*;
import static jakarta.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = ADDRESSES)
@Where(clause = DELETED_ZERO)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = ADDRESS_ID, unique = true,
            updatable = false, nullable = false)
    private UUID id;

    @Enumerated(STRING)
    @Column(name = CITY, nullable = false)
    private City city;

    @Column(name = STREET, nullable = false)
    private String street;

    @Column(name = HOUSE, nullable = false)
    private String house;

    @Column(name = APARTMENT)
    private String apartment;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = PERSON_ADDRESS,
            joinColumns = @JoinColumn(name = ADDRESS_ID),
            inverseJoinColumns = @JoinColumn(name = PERSON_ID))
    private List<Person> persons;

    @Column(name = DELETED)
    private Integer deleted = 0;

    public void setDeleted() {
        this.deleted = 1;
    }
}
