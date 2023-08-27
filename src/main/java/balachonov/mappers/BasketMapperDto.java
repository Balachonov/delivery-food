package balachonov.mappers;

import balachonov.dto.responses.BasketResponse;
import balachonov.entities.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static balachonov.util.Constants.*;

@Mapper(uses = {DishMapperDto.class}, componentModel = SPRING)
public interface BasketMapperDto {

    @Mapping(source = BASKET_DISHES , target = DISHES_DTO)
    BasketResponse toDto(Basket basket);

    Basket toEntity(BasketResponse basketDTO);

    void updateEntity(BasketResponse basketDTO, @MappingTarget Basket basket);
}
