package balachonov.dto.responses;

import balachonov.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishResponse {

    private UUID id;

    private String name;

    private BigDecimal price;

    private String description;

    private DishType type;

    private List<OrderResponse> orderResponses;
}