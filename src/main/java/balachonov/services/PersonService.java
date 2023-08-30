package balachonov.services;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;

import java.util.List;
import java.util.UUID;


public interface PersonService {

    PersonResponse savePerson(PersonRequest personRequest);

    PersonResponse getPersonById(UUID id);

    PersonResponse getPersonByEmail(String email);

    PersonResponse updatePerson(PersonRequest personRequest, UUID id);

    void deletePerson(UUID id);

    List<PersonResponse> getPersons();
}