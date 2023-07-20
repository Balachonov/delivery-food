package balachonov.repositories;

import balachonov.dto.FoodDTO;
import balachonov.entities.Food;
import balachonov.entities.FoodType;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends GeneralOperation<String, Food, FoodDTO> {
       List<Food> readOrdersFoodByType (FoodType type);
}
