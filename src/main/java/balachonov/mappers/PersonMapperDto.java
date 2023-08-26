package balachonov.mappers;

import balachonov.dto.requests.PersonDtoRequest;
import balachonov.dto.responses.PersonDtoResponse;
import balachonov.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static balachonov.util.Constants.*;

@Mapper(uses = {AddressMapperDto.class, BasketMapperDto.class}, componentModel = SPRING)
public interface PersonMapperDto {


    @Mapping(target = PASSWORD, ignore = true)
    @Mapping(target = SALT, ignore = true)
    @Mapping(target = ROLE, ignore = true)
    @Mapping(source = PERSON_ADDRESSES, target = ADDRESSES_DTO)
    @Mapping(source = PERSON_BASKETS, target = BASKETS_DTO)
    PersonDtoResponse toDto(Person person);

    PersonDtoResponse createPersonDtoResponse(PersonDtoRequest personDtoRequest);

    @DoIgnore
    @Mapping(source = PERSON_ADDRESSES, target = ADDRESSES_DTO)
    @Mapping(source = PERSON_BASKETS, target = BASKETS_DTO)
    PersonDtoResponse toFullDto(Person person);

    Person toEntity(PersonDtoResponse personDTO);

    void updateEntity(PersonDtoResponse personDTO, @MappingTarget Person person);
}
