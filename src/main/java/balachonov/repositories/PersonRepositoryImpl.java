package balachonov.repositories;

import balachonov.dto.PersonDto;
import balachonov.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import static balachonov.mappers.PersonMapperDto.personMapperDto;
import static balachonov.util.Constants.*;
import static balachonov.util.JPAUtil.getEntityManager;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Optional<Person> create(PersonDto personDto) {
        Person person = personMapperDto.toEntity(personDto);
        EntityManager em = getEntityManager();
        em.getTransaction();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(person);
    }

    @Override
    public List<Person> readAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = cb.createQuery(Person.class);
        Root<Person> personRoot = personCriteriaQuery.from(Person.class);
        personCriteriaQuery.select(personRoot);
        List<Person> persons = em.createQuery(personCriteriaQuery).getResultList();
        em.close();
        return persons;
    }

    @Override
    public List<Person> readAllWithRestriction(String role) {
        return getPersons(ROLE, role);
    }

    @Override
    public List<Person> readArchiveUsers() {
        return getPersons(DELETED, ONE);
    }

    @Override
    public Optional<Person> readById(String id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.close();
        return Optional.ofNullable(person);
    }

    @Override
    public Optional<Person> update(PersonDto personDto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, personDto.getId());
        personMapperDto.updateEntity(personDto, person);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(person);
    }

    @Override
    public Optional<Person> delete(PersonDto personDto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, personDto.getId());
        person.setDeleted();
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(person);
    }

    @Override
    public Optional<Person> readUserByEmail(String email) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = cb.createQuery(Person.class);
        Root<Person> personRoot = personCriteriaQuery.from(Person.class);
        personCriteriaQuery.select(personRoot).where(cb.like(personRoot.get(EMAIL), email));
        Optional<Person> person = Optional.ofNullable(em.createQuery(personCriteriaQuery).getSingleResult());
        em.close();
        return person;
    }

    private List<Person> getPersons(String field, String restriction) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = cb.createQuery(Person.class);
        Root<Person> personRoot = personCriteriaQuery.from(Person.class);
        personCriteriaQuery.select(personRoot).where(cb.like(personRoot.get(field), restriction));
        List<Person> persons = em.createQuery(personCriteriaQuery).getResultList();
        em.close();
        return persons;
    }
}