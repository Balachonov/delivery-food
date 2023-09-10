package balachonov.services;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;

import java.util.List;
import java.util.UUID;

public interface DishService {

    /**
     * Saving Dish
     * @return DishResponse
     */

    DishResponse saveDish(DishRequest dishRequest);

    /**
     * Getting Dish by ID
     * @return DishResponse
     */

    DishResponse getDishById(UUID id);

    /**
     * Getting Dish by name
     * @return DishResponse
     */

    DishResponse getDishByName(String name);

    /**
     * Getting all Dish
     * @return List of DishResponse
     */

    List<DishResponse> getDishes();

    /**
     * Updating Dish
     * @return DishResponse
     */

    DishResponse updateDish(DishRequest dishRequest, UUID id);

    /**
     * Deleting Dish by ID
     */

    void deleteDish(UUID id);
}