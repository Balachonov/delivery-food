package balachonov.dto.responses;

import balachonov.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDtoResponse {
    private UUID id;
    private Person owner;
    private List<DishDtoResponse> dishesDto;
    private String description;
    private LocalDateTime orderTime;
    private Integer closed;
}
