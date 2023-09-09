package balachonov.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonArchiveResponse {

    private String firstName;

    private String lastName;

    private String email;

    private String telephone;
}