package balachonov.services.impl;

import balachonov.arguments.persons.*;
import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Person;
import balachonov.mappers.PersonArchiveMapperDto;
import balachonov.mappers.PersonMapperDto;
import balachonov.repositories.PersonRepository;
import balachonov.services.EmailService;
import balachonov.services.PasswordGenerationAndCheck;
import balachonov.services.PersonArchiveService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("PersonService test")
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private EmailService emailService;
    @Mock
    private PersonArchiveService archiveService;
    @Mock
    private PasswordGenerationAndCheck passwordService;

    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Autowired
    private PersonMapperDto personMapperDto;
    @Autowired
    private PersonArchiveMapperDto personArchiveMapperDto;

    @BeforeEach
    void init() {
        personServiceImpl = new PersonServiceImpl(personMapperDto, personArchiveMapperDto,
                emailService, archiveService, passwordService, personRepository);
    }

    @ParameterizedTest
    @ArgumentsSource(InputPerson.class)
    void savePerson(PersonRequest personRequest, Person person, PersonResponse expecedPersonResponse) {
        when(personRepository.save(any(Person.class))).thenReturn(person);
        PersonResponse actualPersonResponse = personServiceImpl.savePerson(personRequest);
        assertEquals(expecedPersonResponse, actualPersonResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputPerson.class)
    void getPersonById(Person person, PersonResponse expecedPersonResponse) {
        when(personRepository.findById(any(UUID.class))).thenReturn(ofNullable(person));
        PersonResponse actualPersonResponse = personServiceImpl.getPersonById(person.getId());
        assertEquals(expecedPersonResponse, actualPersonResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputPerson.class)
    void getPersonByEmail(Person person, PersonResponse expecedPersonResponse) {
        when(personRepository.findByEmail(any(String.class))).thenReturn(ofNullable(person));
        PersonResponse actualPersonResponse = personServiceImpl.getPersonByEmail(person.getEmail());
        assertEquals(expecedPersonResponse, actualPersonResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(UpdatedPerson.class)
    void updatePerson(PersonRequest personRequest, Person person, PersonResponse expecedPersonResponse) {
        when(personRepository.findById(any(UUID.class))).thenReturn(ofNullable(person));
        when(personRepository.save(any(Person.class))).thenReturn(person);
        PersonResponse actualPersonResponse = personServiceImpl.updatePerson(personRequest, person.getId());
        assertEquals(expecedPersonResponse, actualPersonResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidPerson.class)
    void getPersonByIdException(Person person) {
        when(personRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) personServiceImpl.getPersonById(person.getId()));
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidPerson.class)
    void getPersonByEmailException(Person person) {
        when(personRepository.findByEmail(any(String.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) personServiceImpl.getPersonByEmail(person.getEmail()));
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidUpdatedPerson.class)
    void updatePersonException(PersonRequest personRequest, UUID id) {
        when(personRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) personServiceImpl.updatePerson(personRequest, id));
    }
}