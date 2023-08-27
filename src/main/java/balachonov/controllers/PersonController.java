package balachonov.controllers;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.services.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService PERSON_SERVICE;

    @PostMapping(value = "/person")
    public PersonResponse saveUser(@Valid @RequestBody PersonRequest personRequest) {
        return PERSON_SERVICE.savePerson(personRequest);
    }

    @GetMapping(value = "/personById/{id}")
    public PersonResponse readPersonById(@PathVariable UUID id) {
        return PERSON_SERVICE.readPersonById(id);
    }

    @GetMapping(value = "/personByEmail/{email}")
    public PersonResponse readPersonById(@PathVariable String email) {
        return PERSON_SERVICE.readPersonByEmail(email);
    }

    @GetMapping(value = "/persons")
    public List<PersonResponse> getPersons() {
        return PERSON_SERVICE.getAllPersons();
    }

    @GetMapping(value = "/personsArchive")
    public List<PersonResponse> readArchivePersons() {
        return PERSON_SERVICE.readArchivePersons();
    }

    @GetMapping(value = "/personsActive")
    public List<PersonResponse> getAllActivePersons() {
        return PERSON_SERVICE.getAllActivePersons();
    }

    @PutMapping(value = "/person/{id}")
    public PersonResponse deletePerson(@PathVariable UUID id) {
        return PERSON_SERVICE.deletePerson(id);
    }
}