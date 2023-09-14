package balachonov.services;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;


public interface PersonService {

    /**
     * Saving Person
     *
     * @return PersonResponse
     */

    PersonResponse savePerson(PersonRequest personRequest);

    /**
     * Getting Person by ID
     *
     * @return PersonResponse
     */

    PersonResponse getPersonById(UUID id);

    /**
     * Getting Person by email
     *
     * @return PersonResponse
     */

    PersonResponse getPersonByEmail(String email);

    /**
     * Updating Person
     *
     * @return PersonResponse
     */

    PersonResponse updatePerson(PersonRequest personRequest, UUID id);

    /**
     * Deleting Person by ID
     */

    void deletePerson(UUID id);

    /**
     * Creating a page with a list of Person and sorting
     *
     * @return Page of PersonResponse
     */

    List<PersonResponse> getPersons(Pageable pageable);
}