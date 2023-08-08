package balachonov.services;

import balachonov.dto.PersonDto;
import balachonov.entities.Person;
import balachonov.repositories.GeneralOperation;

import java.util.List;
import java.util.Optional;

public interface PersonService extends GeneralOperation<String, Person, PersonDto> {
        List<String> readPersonOrders(PersonDto personDTO);
        Optional<Person> readPersonByEmail(String email);
        Optional<Person> readPersonByAddress(String address);
        List<Person> readArchivePersons();
}
