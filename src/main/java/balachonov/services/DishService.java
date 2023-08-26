package balachonov.services;

import balachonov.dto.requests.DishDtoRequest;
import balachonov.dto.responses.DishDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DishService {
    DishDtoResponse saveDish(DishDtoRequest dishDtoRequest);

    DishDtoResponse readDishById(UUID id);

    DishDtoResponse readDishByName(String name);

    List<DishDtoResponse> getAllActiveDishes();

    List<DishDtoResponse> getAllDish();

    List<DishDtoResponse> readArchiveDishes();

    DishDtoResponse deleteDish(String id);
}