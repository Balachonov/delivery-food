package balachonov.dto.requests;

import balachonov.dto.responses.DishResponse;
import balachonov.entities.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketRequest {

    @NotBlank
    private Person owner;

    @NotEmpty
    private List<DishResponse> dishesDto;

    @NotBlank
    private String description;

    private LocalDateTime orderTime;

    private Integer closed;
}