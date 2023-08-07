package balachonov.mappers;

import balachonov.dto.BasketDto;
import balachonov.entities.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper(uses = {DishMapperDto.class})
public interface BasketMapperDto {
    BasketMapperDto basketMapperDto = Mappers.getMapper(BasketMapperDto.class);

    @Mapping(source = BASKET_DISHES , target = DISHES)
    BasketDto toDto(Basket basket);

    Basket toEntity(BasketDto basketDTO);

    void updateEntity(BasketDto basketDTO, @MappingTarget Basket basket);
}
