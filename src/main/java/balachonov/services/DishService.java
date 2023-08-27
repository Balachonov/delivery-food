package balachonov.services;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;

import java.util.List;
import java.util.UUID;

public interface DishService {
    DishResponse saveDish(DishRequest dishDtoRequest);

    DishResponse readDishById(UUID id);

    DishResponse readDishByName(String name);

    List<DishResponse> getAllActiveDishes();

    List<DishResponse> getAllDish();

    List<DishResponse> readArchiveDishes();

    DishResponse deleteDish(String id);
}