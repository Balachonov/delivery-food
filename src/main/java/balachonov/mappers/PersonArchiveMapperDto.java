package balachonov.mappers;

import balachonov.dto.responses.PersonArchiveResponse;
import balachonov.dto.responses.PersonResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(componentModel = SPRING,
        nullValuePropertyMappingStrategy = IGNORE)
public interface PersonArchiveMapperDto {

    PersonArchiveResponse mapToPersonArchive(PersonResponse personResponse);
}