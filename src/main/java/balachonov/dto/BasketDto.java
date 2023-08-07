package balachonov.dto;

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
public class BasketDto {
    private String id;
    private Person owner;
    private List<DishDto> dishes;
    private String description;
    private LocalDateTime orderTime;
    private Integer closed;
}
