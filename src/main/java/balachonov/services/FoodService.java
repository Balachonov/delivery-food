package balachonov.services;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;
import balachonov.enums.DishType;
import balachonov.repositories.GeneralOperation;

import java.util.List;

public interface FoodService extends GeneralOperation<String, Dish, DishDto> {
       List<Dish> readOrdersFoodByType (DishType type);
}
