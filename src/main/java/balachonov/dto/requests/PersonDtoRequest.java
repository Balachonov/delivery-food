package balachonov.dto.requests;

import balachonov.dto.responses.AddressDtoResponse;
import balachonov.dto.responses.BasketDtoResponse;
import balachonov.enums.PersonRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDtoRequest {
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDtoResponse> addressesDto;
    private String password;
    private PersonRole role;
    private List<BasketDtoResponse> basketsDto;
    private Integer deleted;
}
