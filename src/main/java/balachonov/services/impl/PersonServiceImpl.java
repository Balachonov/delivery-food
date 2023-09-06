package balachonov.services.impl;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Person;
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

    private final PersonMapperDto personMapper;
    private final EmailService emailService;
    private final PasswordGenerationAndCheck passwordService;
    private final PersonRepository personRepository;

    @Override
    public PersonResponse savePerson(PersonRequest personRequest) {
        Person person = personMapper.mapToPerson(personRequest);
        person.setPassword(passwordService.getHashPassword(personRequest.getPassword()))
                .setRole(PersonRole.USER);
        emailService.sendSuccessfulRegistrationMail(person.getEmail());
        person = personRepository.save(person);
        return personMapper.mapToPersonResponse(person);
    }

    @Override
    public PersonResponse getPersonById(UUID id) {
        return personRepository.findById(id)
                .map(personMapper::mapToPersonResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(PERSON_NOT_FOUND_BY_ID, id)));
    }

    @Override
    public PersonResponse getPersonByEmail(String email) {
        return personRepository.findByEmail(email)
                .map(personMapper::mapToPersonResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(PERSON_NOT_FOUND_BY_EMAIL, email)));
    }

    @Override
    public PersonResponse updatePerson(PersonRequest personRequest, UUID id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format(PERSON_NOT_FOUND_BY_ID, id)));
        personMapper.updatePerson(personRequest, person);
        person = personRepository.save(person);
        return personMapper.mapToPersonResponse(person);
    }

    @Override
    public void deletePerson(UUID id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonResponse> getPersons() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::mapToPersonResponse)
                .toList();
    }
}