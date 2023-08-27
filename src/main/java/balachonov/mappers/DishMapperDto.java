package balachonov.mappers;

import balachonov.dto.responses.DishResponse;
import balachonov.entities.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static balachonov.util.Constants.*;

@Mapper(uses = {BasketMapperDto.class}, componentModel = SPRING)
public interface DishMapperDto {

    @Mapping(source = DISH_BASKETS, target = BASKETS_DTO)
    DishResponse toDto(Dish dish);

    Dish toEntity(DishResponse dishDTO);

    void updateEntity(DishResponse dishDTO, @MappingTarget Dish dish);
}
