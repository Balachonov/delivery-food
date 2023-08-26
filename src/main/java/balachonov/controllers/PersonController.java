package balachonov.controllers;

import balachonov.dto.requests.PersonDtoRequest;
import balachonov.dto.responses.PersonDtoResponse;
import balachonov.services.EmailService;
import balachonov.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService PERSON_SERVICE;

    @PostMapping(value = "person")
    public PersonDtoResponse saveUser(@RequestBody PersonDtoRequest personDtoRequest) {
        return PERSON_SERVICE.savePerson(personDtoRequest);
    }

    @GetMapping(value = "personById/{id}")
    public PersonDtoResponse readPersonById(@PathVariable UUID id) {
        return PERSON_SERVICE.readPersonById(id);
    }

    @GetMapping(value = "personByEmail/{email}")
    public PersonDtoResponse readPersonById(@PathVariable String email) {
        return PERSON_SERVICE.readPersonByEmail(email);
    }

    @GetMapping(value = "persons")
    public List<PersonDtoResponse> getPersons() {
        return PERSON_SERVICE.getAllPersons();
    }

    @GetMapping(value = "personsArchive")
    public List<PersonDtoResponse> readArchivePersons() {
        return PERSON_SERVICE.readArchivePersons();
    }

    @GetMapping(value = "personsActive")
    public List<PersonDtoResponse> getAllActivePersons() {
        return PERSON_SERVICE.getAllActivePersons();
    }

    @PutMapping(value = "personDelete/{id}")
    public PersonDtoResponse deletePerson(@PathVariable UUID id) {
        return PERSON_SERVICE.deletePerson(id);
    }
}
