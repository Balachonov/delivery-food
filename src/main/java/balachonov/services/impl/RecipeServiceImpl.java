package balachonov.services.impl;

import balachonov.dto.responses.RecipeResponse;
import balachonov.feingClients.RecipeClient;
import balachonov.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeClient recipeClient;

    @Override
    public RecipeResponse getRecipe() {
        return recipeClient.getRecipe(LocalDate.now().getDayOfWeek());
    }
}