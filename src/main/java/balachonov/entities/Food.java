package balachonov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Food")
@Table(name = "FOODS")
@Where(clause = "DELETED = 0")
public class Food implements Serializable {

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

    @OneToMany(mappedBy = "food")
    List<UserFood> orders;

    @Column(name = "DELETED")
    private Integer deleted = 0;

    public void setDeleted() {
        this.deleted = 1;
    }
}
