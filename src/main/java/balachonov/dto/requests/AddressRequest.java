package balachonov.dto.requests;

import balachonov.dto.responses.PersonResponse;
import balachonov.enums.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {

    @NotBlank
    private City city;

    @NotBlank
    private String street;

    @NotBlank
    private String house;

    private String apartment;

    @NotEmpty
    private List<PersonResponse> personsDto;

    private Integer deleted;
}