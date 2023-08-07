package balachonov.dto;

import balachonov.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishDto {
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private DishType type;
    private List<BasketDto> baskets;
    private Integer deleted;
}
