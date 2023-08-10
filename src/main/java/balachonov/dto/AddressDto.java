package balachonov.dto;

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
public class AddressDto {
    private String id;
    private City city;
    private String street;
    private String house;
    private String apartment;
    private List<PersonDto> personsDto;
    private Integer deleted;
}
