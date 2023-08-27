package balachonov.dto.requests;

import balachonov.dto.responses.AddressResponse;
import balachonov.dto.responses.BasketResponse;
import balachonov.enums.PersonRole;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    private List<AddressResponse> addressesDto;

    @NotBlank
    @Size(min = 8)
    private String password;

    private PersonRole role;

    private List<BasketResponse> basketsDto;

    private Integer deleted;
}