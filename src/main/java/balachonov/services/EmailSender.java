package balachonov.services;

import balachonov.dto.responses.PersonDtoResponse;

public interface EmailSender {
    void sendMessageFromGmail(PersonDtoResponse personDto);
}
