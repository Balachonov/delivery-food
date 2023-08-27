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

    private final RecipeClient RECIPE_CLIENT;

    @Override
    public RecipeResponse getRecipe() {
        return RECIPE_CLIENT.getRecipe(LocalDate.now().getDayOfWeek());
    }
}