package balachonov.services;

public interface EmailService {
    void sendSuccessfulBasketMail(String email);

    void sendSuccessfulRegistrationMail(String email);
}