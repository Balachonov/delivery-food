package balachonov.services;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;

import java.util.List;
import java.util.UUID;


public interface PersonService {
    PersonResponse savePerson(PersonRequest personDtoRequest);

    PersonResponse readPersonById(UUID id);

    PersonResponse readPersonByEmail(String email);

    List<PersonResponse> getAllActivePersons();

    List<PersonResponse> getAllPersons();

    List<PersonResponse> readArchivePersons();

    PersonResponse deletePerson(UUID id);
}