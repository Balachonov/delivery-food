package balachonov.mappers;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import static balachonov.util.Constants.*;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(uses = {OrderMapperDto.class},
        componentModel = SPRING,
        nullValuePropertyMappingStrategy = IGNORE)
public interface PersonMapperDto {

    @Mapping(target = PASSWORD, ignore = true)
    @Mapping(target = ROLE, ignore = true)
    @Mapping(source = PERSON_ORDERS, target = ORDER_RESPONSES)
    PersonResponse mapToPersonResponse(Person person);

    PersonResponse mapToPersonResponse(PersonRequest personRequest);

    @DoIgnore
    @Mapping(source = PERSON_ORDERS, target = ORDER_RESPONSES)
    PersonResponse mapToFullPersonResponse(Person person);

    Person mapToPerson(PersonResponse personResponse);

    Person mapToPerson(PersonRequest personRequest);

    void updatePerson(PersonRequest personRequest, @MappingTarget Person person);
}
