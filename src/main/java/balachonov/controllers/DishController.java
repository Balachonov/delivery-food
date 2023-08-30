package balachonov.controllers;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;
import balachonov.services.DishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @PostMapping(value = "/dish")
    public DishResponse saveDish(@Valid @RequestBody DishRequest dishRequest) {
        return dishService.saveDish(dishRequest);
    }

    @GetMapping(value = "/dishById/{id}")
    public DishResponse getDishById(@PathVariable UUID id) {
        return dishService.getDishById(id);
    }

    @GetMapping(value = "/dishByEmail/{name}")
    public DishResponse getDishByName(@PathVariable String name) {
        return dishService.getDishByName(name);
    }

    @PutMapping(value = "/dish/{id}")
    public DishResponse updateDish(@Valid @RequestBody DishRequest dishRequest, @PathVariable UUID id) {
        return dishService.updateDish(dishRequest, id);
    }

    @DeleteMapping(value = "/dish/{id}")
    public void deleteDish(@PathVariable UUID id) {
        dishService.deleteDish(id);
    }

    @GetMapping(value = "/dishes")
    public List<DishResponse> getDishes() {
        return dishService.getDishes();
    }
}