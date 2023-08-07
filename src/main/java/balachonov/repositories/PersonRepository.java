package balachonov.repositories;

import balachonov.dto.PersonDto;
import balachonov.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends GeneralOperation<String, Person, PersonDto> {
    Optional<Person> readUserByEmail(String email);

    List<Person> readArchiveUsers();
}