package balachonov.dto;

import balachonov.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private UserRole userRole;
}
