package balachonov.services.impl;

import balachonov.dto.responses.MailInfo;
import balachonov.feingClients.MailClient;
import balachonov.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final MailClient mailClient;

    @Override
    public void sendSuccessfulOrderMail(MailInfo mailInfo) {
        mailClient.sendOrderMail(mailInfo);
    }

    @Override
    public void sendSuccessfulRegistrationMail(MailInfo mailInfo) {
        mailClient.sendRegistrationMail(mailInfo);
    }
}