package balachonov.dto;

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
public class PersonDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDto> addressesDto;
    private String password;
    private String salt;
    private PersonRole role;
    private List<BasketDto> basketsDto;
    private Integer deleted;
}
