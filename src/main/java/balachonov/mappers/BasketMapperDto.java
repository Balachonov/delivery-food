package balachonov.mappers;

import balachonov.dto.responses.BasketDtoResponse;
import balachonov.entities.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper(uses = {DishMapperDto.class}, componentModel = SPRING)
public interface BasketMapperDto {

    @Mapping(source = BASKET_DISHES , target = DISHES_DTO)
    BasketDtoResponse toDto(Basket basket);

    Basket toEntity(BasketDtoResponse basketDTO);

    void updateEntity(BasketDtoResponse basketDTO, @MappingTarget Basket basket);
}
