package balachonov.services;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;

import java.util.List;
import java.util.UUID;

public interface DishService {

    DishResponse saveDish(DishRequest dishRequest);

    DishResponse getDishById(UUID id);

    DishResponse getDishByName(String name);

    List<DishResponse> getDishes();

    DishResponse updateDish(DishRequest dishRequest, UUID id);

    void deleteDish(UUID id);
}