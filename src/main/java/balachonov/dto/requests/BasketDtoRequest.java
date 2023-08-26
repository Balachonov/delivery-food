package balachonov.dto.requests;

import balachonov.dto.responses.DishDtoResponse;
import balachonov.entities.Person;
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
public class BasketDtoRequest {
    private Person owner;
    private List<DishDtoResponse> dishesDto;
    private String description;
    private LocalDateTime orderTime;
    private Integer closed;
}
