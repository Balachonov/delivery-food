package balachonov.services;

public interface EmailService {

    void sendSuccessfulOrderMail(String email);

    void sendSuccessfulRegistrationMail(String email);
}