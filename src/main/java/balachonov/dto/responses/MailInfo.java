package balachonov.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailInfo {

    private static String companyEmail = "${spring.mail.username}";

    private String personEmail;
}