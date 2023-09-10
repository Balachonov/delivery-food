package balachonov.repositories;

import balachonov.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    /**
     * Searching Person in database by email
     * @return Person
     */

    Optional<Person> findByEmail(String email);
}