package balachonov.entities;

import balachonov.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static balachonov.util.Constants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = DISHES)
@Where(clause = DELETED_ZERO)
public class Dish {

    @Id
    @GeneratedValue(generator = UUID)
    @GenericGenerator(name = UUID,
            strategy = UUID_STRATEGY)
    @Column(name = DISH_ID, unique = true)
    private String id;

    @Column(name = NAME, nullable = false)
    private String name;

    @Column(name = PRICE, nullable = false)
    private BigDecimal price;

    @Column(name = DESCRIPTION, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = TYPE, nullable = false)
    private DishType type;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = BASKET_DISH,
            joinColumns = @JoinColumn(name = DISH_ID),
            inverseJoinColumns = @JoinColumn(name = BASKET_ID))
    private List<Basket> baskets;

    @Column(name = DELETED)
    private Integer deleted = 0;

    public void setDeleted() {
        this.deleted = 1;
    }
}
