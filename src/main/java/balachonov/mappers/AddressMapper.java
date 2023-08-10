package balachonov.mappers;

import balachonov.entities.Address;
import balachonov.entities.Person;
import balachonov.enums.City;

import java.util.List;

public class AddressMapper {

    private static AddressMapper addressMapper;

    public static AddressMapper getAddressMapper() {
        if(addressMapper == null) {
            addressMapper = new AddressMapper();
        }
        return addressMapper;
    }

    public Address buildAddress(City city, String street, String house, String apartment,
                                List<Person> persons, Integer deleted){
        return Address.builder()
                .city(city)
                .street(street)
                .house(house)
                .apartment(apartment)
                .persons(persons)
                .deleted(deleted)
                .build();
    }
    public Address buildAddressById(String id, City city, String street, String house, String apartment,
                                List<Person> persons, Integer deleted){
        return Address.builder()
                .id(id)
                .city(city)
                .street(street)
                .house(house)
                .apartment(apartment)
                .persons(persons)
                .deleted(deleted)
                .build();
    }

    private AddressMapper(){
    }
}
