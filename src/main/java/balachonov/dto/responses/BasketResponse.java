package balachonov.dto.responses;

import balachonov.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketResponse {

    private UUID id;
    private Person owner;
    private List<DishResponse> dishesDto;
    private String description;
    private LocalDateTime orderTime;
    private Integer closed;
}
