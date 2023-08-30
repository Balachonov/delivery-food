package balachonov.entities;

import balachonov.enums.DishType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.*;
import static jakarta.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = DISHES)
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DISH_ID,
            updatable = false)
    private UUID id;

    @Column(name = NAME,
            nullable = false,
            length = 50)
    private String name;

    @Column(name = PRICE,
            nullable = false)
    private BigDecimal price;

    @Column(name = DESCRIPTION,
            nullable = false)
    private String description;

    @Enumerated(STRING)
    @Column(name = TYPE,
            nullable = false)
    private DishType type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = BASKET_DISH,
            joinColumns = @JoinColumn(name = DISH_ID),
            inverseJoinColumns = @JoinColumn(name = BASKET_ID))
    private List<Order> orders;
}