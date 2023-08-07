package balachonov.services;

import balachonov.dto.PersonDto;
import balachonov.entities.Person;
import balachonov.repositories.GeneralOperation;

import java.util.List;
import java.util.Optional;

public interface UserService extends GeneralOperation<String, Person, PersonDto> {
        List<String> readUserOrders(PersonDto personDTO);
        Optional<Person> readUserByEmail(String email);
        Optional<Person> readUserByAddress(String address);
        List<Person> readArchiveUsers ();
}
