package balachonov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;
    private String salt;
    private UserRole userRole;
}
