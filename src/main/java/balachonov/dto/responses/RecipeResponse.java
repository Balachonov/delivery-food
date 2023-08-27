package balachonov.dto.responses;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.DayOfWeek;
@Data
public class RecipeResponse {
    @NotBlank
    private DayOfWeek dayOfWeek;
    @NotBlank
    private String complexity;
    @NotBlank
    private String recipeDescription;
}
