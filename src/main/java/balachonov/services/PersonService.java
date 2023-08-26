package balachonov.services;

import balachonov.dto.requests.PersonDtoRequest;
import balachonov.dto.responses.PersonDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PersonService {
    PersonDtoResponse savePerson(PersonDtoRequest personDtoRequest);

    PersonDtoResponse readPersonById(UUID id);

    PersonDtoResponse readPersonByEmail(String email);

    List<PersonDtoResponse> getAllActivePersons();

    List<PersonDtoResponse> getAllPersons();

    List<PersonDtoResponse> readArchivePersons();

    PersonDtoResponse deletePerson(UUID id);
}