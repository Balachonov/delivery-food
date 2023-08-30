package balachonov.services.impl;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;
import balachonov.entities.Dish;
import balachonov.mappers.DishMapperDto;
import balachonov.repositories.DishRepository;
import balachonov.services.DishService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static balachonov.util.Constants.DISH_NOT_FOUND_BY_ID;
import static balachonov.util.Constants.DISH_NOT_FOUND_BY_NAME;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishMapperDto dishMapper;

    @Override
    public DishResponse saveDish(DishRequest dishRequest) {
        Dish dish = dishRepository.save(dishMapper.mapToDish(dishRequest));
        return dishMapper.mapToDishResponse(dish);
    }

    @Override
    public DishResponse getDishById(UUID id) {
        return dishRepository.findById(id)
                .map(dishMapper::mapToDishResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(DISH_NOT_FOUND_BY_ID, id)));
    }

    @Override
    public DishResponse getDishByName(String name) {
        return dishRepository.findByName(name)
                .map(dishMapper::mapToDishResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(DISH_NOT_FOUND_BY_NAME, name)));
    }

    @Override
    public DishResponse updateDish(DishRequest dishRequest, UUID id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format(DISH_NOT_FOUND_BY_ID, id)));
        dishMapper.updateDish(dishRequest, dish);
        dish = dishRepository.save(dish);
        return dishMapper.mapToDishResponse(dish);
    }

    @Override
    public void deleteDish(UUID id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<DishResponse> getDishes() {
        return dishRepository.findAll()
                .stream()
                .map(dishMapper::mapToDishResponse)
                .toList();
    }
}