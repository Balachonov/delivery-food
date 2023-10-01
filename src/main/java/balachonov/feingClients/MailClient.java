package balachonov.feingClients;

import balachonov.dto.responses.MailInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mail-service/mail")
public interface MailClient {

    /**
     * Sending a mail if successful registration
     */
    @PostMapping(value = "/registration")
    void sendRegistrationMail(MailInfo mailInfo);

    /**
     * Sending a mail if order successfully
     */
    @PostMapping(value = "/order")
    void sendOrderMail(MailInfo mailInfo);
}