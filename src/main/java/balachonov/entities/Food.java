package balachonov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "FOODS")
public class Food {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_FOOD", unique = true)
    private String idFood;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "WEIGHT")
    private Float weight;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COMPOSITION")
    private String composition;

    @Enumerated(EnumType.STRING)
    @Column(name = "FOOD_TYPE")
    private FoodType foodType;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "USERS_FOODS",
            joinColumns = @JoinColumn(name = "ID_FOOD"),
            inverseJoinColumns = @JoinColumn(name = "ID_USER")
    )
    private List<User> users = new ArrayList<>();
}
