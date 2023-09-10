package balachonov.services;

import balachonov.dto.responses.RecipeResponse;

public interface RecipeService {

    /**
     * Getting a day recipe from a remote API
     */
    RecipeResponse getRecipe();
}