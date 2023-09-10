package balachonov.services;

public interface EmailService {

    /**
     * Sending a mail if order successfully
     */

    void sendSuccessfulOrderMail(String email);

    /**
     * Sending a mail if successful registration
     */

    void sendSuccessfulRegistrationMail(String email);
}