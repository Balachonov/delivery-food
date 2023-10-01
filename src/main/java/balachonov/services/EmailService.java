package balachonov.services;

import balachonov.dto.responses.MailInfo;

public interface EmailService {

    /**
     * Sending a mail if order successfully
     */

    void sendSuccessfulOrderMail(MailInfo mailInfo);

    /**
     * Sending a mail if successful registration
     */

    void sendSuccessfulRegistrationMail(MailInfo mailInfo);
}