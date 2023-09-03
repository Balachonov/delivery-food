package balachonov.feingClients;

import balachonov.dto.responses.RecipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;

@FeignClient(value = "recipeClient", url = "${client.recipe.url}")
public interface RecipeClient {
    @GetMapping
    RecipeResponse getRecipe(@RequestParam DayOfWeek dayOfWeek);
}