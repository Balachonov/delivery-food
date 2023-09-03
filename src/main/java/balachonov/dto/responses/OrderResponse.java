package balachonov.dto.responses;

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
public class OrderResponse {

    private UUID id;

    private PersonResponse owner;

    private List<DishResponse> dishResponses;

    private String description;

    private LocalDateTime orderTime;
}