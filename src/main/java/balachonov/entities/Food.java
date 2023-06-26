package balachonov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {
    private String idFood;
    private String name;
    private Float price;
    private Float weight;
    private String description;
    private String composition;
    private FoodType foodType;
}
