package balachonov.dto.responses;

import balachonov.enums.PersonRole;
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
public class PersonResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String telephone;

    private String password;

    private PersonRole role;

    private List<OrderResponse> orderResponses;
}