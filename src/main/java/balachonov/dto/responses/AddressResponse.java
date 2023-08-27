package balachonov.dto.responses;

import balachonov.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {

    private UUID id;
    private City city;
    private String street;
    private String house;
    private String apartment;
    private List<PersonResponse> personsDto;
    private Integer deleted;
}