package balachonov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static balachonov.util.Constants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = BASKETS)
@Where(clause = CLOSED_ZERO)
public class Basket {

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID,
            strategy = UUID_STRATEGY)
    @Column(name = BASKET_ID, unique = true)
    private String id;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = PERSON_ID)
    private Person owner;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = BASKET_DISH,
            joinColumns = @JoinColumn(name = BASKET_ID),
            inverseJoinColumns = @JoinColumn(name = DISH_ID))
    private List<Dish> dishes;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = ORDER_TIME)
    private LocalDateTime orderTime;

    @Column(name = CLOSED)
    private Integer closed = 0;

    public void setClosed() {
        this.closed = 1;
    }
}
