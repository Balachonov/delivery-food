package balachonov.mappers;

import balachonov.entities.Address;
import balachonov.entities.Basket;
import balachonov.entities.Person;
import balachonov.enums.PersonRole;
import balachonov.services.PasswordGenerationAndCheckImpl;

import java.util.List;

import static balachonov.enums.PersonRole.USER;

public class PersonMapper {
    private static PersonMapper personMapper;

    public static PersonMapper getPersonMapper() {
        if (personMapper == null) {
            personMapper = new PersonMapper();
        }
        return personMapper;
    }

    public Person buildPerson(String firstName, String lastName, String email,
                              List<Address> addresses,String inputPassword, List<Basket> orders) {
        String salt = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().generationSalt();
        String password = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().
                getHashPassword(inputPassword, salt);
        String personRole = String.valueOf(USER);
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .addresses(addresses)
                .password(password)
                .salt(salt)
                .role(PersonRole.valueOf(personRole))
                .orders(orders)
                .build();
    }

    public Person adminBuildPerson(String firstName, String lastName, String email,
                                   List<Address> addresses,String inputPassword,
                                   String personRole, List<Basket> orders, Integer deleted) {
        String salt = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().generationSalt();
        String password = PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().
                getHashPassword(inputPassword, salt);
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .addresses(addresses)
                .password(password)
                .salt(salt)
                .role(PersonRole.valueOf(personRole))
                .orders(orders)
                .deleted(deleted)
                .build();
    }

    public Person buildPersonById(String idUser, String firstName, String lastName, String email,
                                  List<Address> addresses, String password, String salt, String personRole,
                                  List<Basket> orders, Integer deleted) {

        return Person.builder()
                .id(idUser)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .addresses(addresses)
                .password(password)
                .salt(salt)
                .role(PersonRole.valueOf(personRole))
                .orders(orders)
                .deleted(deleted)
                .build();
    }

    private PersonMapper() {
    }
}