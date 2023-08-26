package balachonov.dto.responses;

import balachonov.dto.responses.AddressDtoResponse;
import balachonov.dto.responses.BasketDtoResponse;
import balachonov.enums.PersonRole;
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
public class PersonDtoResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDtoResponse> addressesDto;
    private String password;
    private String salt;
    private PersonRole role;
    private List<BasketDtoResponse> basketsDto;
    private Integer deleted;
}
