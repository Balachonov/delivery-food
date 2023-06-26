package balachonov.repositories;

import balachonov.entities.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    /**
     * Create a new food
     */
    Food create(Food food);

    /**
     * Get food by ID
     */
    Optional<Food> getFoodById(String idFood);

    /**
     * Get food by name
     */
    Optional<Food> getFoodByName(String name);

    /**
     * Update a food
     */
    Optional<Food> updateFood(String foodId, Food food);

    /**
     * Get all food
     */
    List<Food> getAllFood();

    /**
     * Delete a food
     */
    Optional<Food> deleteFood(String idFood);
}
