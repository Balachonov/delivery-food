package balachonov.dto.requests;

import balachonov.enums.DishType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class DishRequest {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String description;

    @NotBlank
    private DishType type;

    private List<OrderRequest> orderRequests;
}