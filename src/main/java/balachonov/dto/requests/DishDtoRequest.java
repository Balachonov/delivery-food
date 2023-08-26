package balachonov.dto.requests;

import balachonov.dto.responses.BasketDtoResponse;
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
public class DishDtoRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private DishType type;
    private List<BasketDtoResponse> basketsDto;
    private Integer deleted;
}
