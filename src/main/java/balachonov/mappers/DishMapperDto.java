package balachonov.mappers;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;
import balachonov.entities.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static balachonov.util.Constants.*;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(uses = {OrderMapperDto.class},
        componentModel = SPRING,
        nullValuePropertyMappingStrategy = IGNORE)
public interface DishMapperDto {

    /**
     * Mapping Dish entity to DishResponse
     * @return DishResponse
     */

    @Mapping(source = DISH_ORDERS, target = ORDER_RESPONSES)
    DishResponse mapToDishResponse(Dish dish);

    /**
     * Mapping DishRequest to Dish entity
     * @return Dish
     */

    Dish mapToDish(DishRequest dishRequest);

    /**
     * Updating Dish entity
     */

    void updateDish(DishRequest dishRequest, @MappingTarget Dish dish);
}