package balachonov.services.impl;

import balachonov.dto.requests.PersonDtoRequest;
import balachonov.dto.responses.PersonDtoResponse;
import balachonov.enums.PersonRole;
import balachonov.mappers.PersonMapperDto;
import balachonov.repositories.PersonRepository;
import balachonov.services.EmailService;
import balachonov.services.PasswordGenerationAndCheck;
import balachonov.services.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.PERSON_NOT_FOUND_BY_EMAIL;
import static balachonov.util.Constants.PERSON_NOT_FOUND_BY_ID;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final EmailService EMAIL_SERVICE;
    private final PersonRepository PERSON_REPOSITORY;
    private final PasswordGenerationAndCheck PASSWORD_SERVICE;
    private final PersonMapperDto PERSON_MAPPER;

    @Override
    public PersonDtoResponse savePerson(PersonDtoRequest personDtoRequest) {
        String salt = PASSWORD_SERVICE.generationSalt();
        PersonDtoResponse personDtoResponse = PERSON_MAPPER.createPersonDtoResponse(personDtoRequest);
        personDtoResponse.setSalt(salt);
        personDtoResponse.setPassword(PASSWORD_SERVICE.getHashPassword(personDtoRequest.getPassword(), salt));
        personDtoResponse.setRole(PersonRole.USER);
        personDtoResponse.setDeleted(0);
        EMAIL_SERVICE.sendSuccessfulRegistrationMail(personDtoRequest.getEmail());
        return PERSON_MAPPER.toDto(PERSON_REPOSITORY.save(PERSON_MAPPER.toEntity(personDtoResponse)));
    }

    @Override
    public PersonDtoResponse readPersonById(UUID id) {
        return PERSON_REPOSITORY.findById(id)
                .map(PERSON_MAPPER::toDto)
                .orElseThrow(() -> new EntityNotFoundException(format(PERSON_NOT_FOUND_BY_ID, id)));
    }

    @Override
    public PersonDtoResponse readPersonByEmail(String email) {
        return PERSON_REPOSITORY.findByEmail(email)
                .map(PERSON_MAPPER::toDto)
                .orElseThrow(() -> new EntityNotFoundException(format(PERSON_NOT_FOUND_BY_EMAIL, email)));
    }

    @Override
    public List<PersonDtoResponse> getAllActivePersons() {
        return getAllPersons()
                .stream()
                .filter(personDtoResponse -> personDtoResponse.getDeleted() == 1)
                .toList();
    }

    @Override
    public List<PersonDtoResponse> getAllPersons() {
        return PERSON_REPOSITORY.findAll()
                .stream()
                .map(PERSON_MAPPER::toDto)
                .toList();
    }

    @Override
    public List<PersonDtoResponse> readArchivePersons() {
        return getAllPersons()
                .stream()
                .filter(personDtoResponse -> personDtoResponse.getDeleted() == 0)
                .toList();
    }

    @Override
    public PersonDtoResponse deletePerson(UUID id) {
        return PERSON_REPOSITORY.deletePerson(id)
                .map(PERSON_MAPPER::toDto)
                .orElseThrow(() -> new EntityNotFoundException(format(PERSON_NOT_FOUND_BY_ID, id)));
    }
}
