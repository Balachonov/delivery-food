package balachonov.controllers;

import balachonov.dto.responses.RecipeResponse;
import balachonov.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping(value = "/recipe")
    public RecipeResponse getRecipe() {
        return recipeService.getRecipe();
    }
}