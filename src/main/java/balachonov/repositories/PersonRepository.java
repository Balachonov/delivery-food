package balachonov.repositories;

import balachonov.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

import static balachonov.util.Constants.PERSON_DELETE;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByEmail(String email);
    @Modifying
    @Query(PERSON_DELETE)
    Optional<Person> deletePerson(UUID id);
}
