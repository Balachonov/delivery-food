package balachonov.dto;

import balachonov.entities.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDTO {
    private String idFood;
    private String name;
    private Float price;
    private Float weight;
    private String description;
    private String composition;
    private FoodType foodType;
}
