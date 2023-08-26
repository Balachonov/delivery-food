package balachonov.dto.requests;

import balachonov.dto.responses.PersonDtoResponse;
import balachonov.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDtoRequest {
    private City city;
    private String street;
    private String house;
    private String apartment;
    private List<PersonDtoResponse> personsDto;
    private Integer deleted;
}