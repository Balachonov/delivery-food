package balachonov.mappers;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import static balachonov.util.Constants.*;
@Component
@Mapper(uses = {AddressMapperDto.class, BasketMapperDto.class}, componentModel = SPRING)
public interface PersonMapperDto {


    @Mapping(target = PASSWORD, ignore = true)
    @Mapping(target = SALT, ignore = true)
    @Mapping(target = ROLE, ignore = true)
    @Mapping(source = PERSON_ADDRESSES, target = ADDRESSES_DTO)
    @Mapping(source = PERSON_BASKETS, target = BASKETS_DTO)
    PersonResponse toDto(Person person);

    PersonResponse createPersonDtoResponse(PersonRequest personDtoRequest);

    @DoIgnore
    @Mapping(source = PERSON_ADDRESSES, target = ADDRESSES_DTO)
    @Mapping(source = PERSON_BASKETS, target = BASKETS_DTO)
    PersonResponse toFullDto(Person person);

    Person toEntity(PersonResponse personDTO);

    void updateEntity(PersonResponse personDTO, @MappingTarget Person person);
}
