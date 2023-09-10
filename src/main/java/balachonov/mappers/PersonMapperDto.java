package balachonov.mappers;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Person;
import balachonov.mappers.anotations.DoIgnore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import static balachonov.util.Constants.*;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(uses = {OrderMapperDto.class},
        componentModel = SPRING,
        nullValuePropertyMappingStrategy = IGNORE)
public interface PersonMapperDto {

    /**
     * Mapping Person entity to PersonResponse with ignoring fields
     * @return PersonResponse
     */

    @Mapping(target = PASSWORD, ignore = true)
    @Mapping(target = ROLE, ignore = true)
    @Mapping(source = PERSON_ORDERS, target = ORDER_RESPONSES)
    PersonResponse mapToPersonResponse(Person person);

    /**
     * Mapping Person entity to PersonResponse
     * @return PersonResponse
     */

    @DoIgnore
    @Mapping(source = PERSON_ORDERS, target = ORDER_RESPONSES)
    PersonResponse mapToFullPersonResponse(Person person);

    /**
     * Mapping PersonRequest to Person entity
     * @return Person
     */

    Person mapToPerson(PersonRequest personRequest);

    /**
     * Updating Person entity
     */

    void updatePerson(PersonRequest personRequest, @MappingTarget Person person);
}