package balachonov.controllers;

import balachonov.aspects.anotations.ExecutionTimeLog;
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

    private final PersonService personService;

    @PostMapping(value = "/person")
    @ExecutionTimeLog
    public PersonResponse savePerson(@Valid @RequestBody PersonRequest personRequest) {
        return personService.savePerson(personRequest);
    }

    @GetMapping(value = "/personById/{id}")
    public PersonResponse getPersonById(@PathVariable UUID id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/personByEmail/{email}")
    public PersonResponse getPersonByEmail(@PathVariable String email) {
        return personService.getPersonByEmail(email);
    }

    @PutMapping(value = "/person/{id}")
    public PersonResponse update(@Valid @RequestBody PersonRequest personRequest, @PathVariable UUID id) {
        return personService.updatePerson(personRequest, id);
    }

    @DeleteMapping(value = "/person/{id}")
    public void delete(@PathVariable UUID id) {
        personService.deletePerson(id);
    }

    @GetMapping(value = "/persons")
    public List<PersonResponse> getPersons() {
        return personService.getPersons();
    }
}