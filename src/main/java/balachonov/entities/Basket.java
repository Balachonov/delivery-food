package balachonov.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = BASKETS)
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = BASKET_ID,
            unique = true,
            updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = PERSON_ID)
    private Person person;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = BASKET_DISH,
            joinColumns = @JoinColumn(name = BASKET_ID),
            inverseJoinColumns = @JoinColumn(name = DISH_ID))
    private List<Dish> dishes;

    @Column(name = DESCRIPTION,
            nullable = false)
    private String description;

    @Column(name = ORDER_TIME)
    private LocalDateTime orderTime;

    @Column(name = CLOSED)
    private Integer closed = 0;

    public void setClosed() {
        this.closed = 1;
    }
}