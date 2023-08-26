package balachonov.services;

import balachonov.dto.responses.PersonDtoResponse;

public interface EmailService {
    void sendSuccessfulBasketMail(String email);
    void sendSuccessfulRegistrationMail(String email);
}
