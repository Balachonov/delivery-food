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

    /**
     * Mapping PersonResponse to PersonArchiveResponse for {@link balachonov.feingClients.PersonArchiveClient}
     * @return PersonArchiveResponse
     */

    PersonArchiveResponse mapToPersonArchive(PersonResponse personResponse);
}