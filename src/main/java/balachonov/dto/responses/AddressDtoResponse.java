package balachonov.dto.responses;

import balachonov.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDtoResponse {
    private UUID id;
    private City city;
    private String street;
    private String house;
    private String apartment;
    private List<PersonDtoResponse> personsDto;
    private Integer deleted;
}