package balachonov.feingClients;

import balachonov.dto.responses.RecipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "recipe-day")
public interface RecipeClient {
    @GetMapping
    RecipeResponse getRecipe();
}