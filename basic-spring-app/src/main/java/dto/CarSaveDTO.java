package dto;

import jakarta.validation.constraints.*;

public record CarSaveDTO(
        @NotBlank(message = "Model cannot be empty")
        @Size(min = 2, max = 50)
        String model,

        @NotBlank(message = "Brand cannot be empty")
        @Size(min = 2, max = 50)
        String brand,

        @NotNull(message = "Year cannot be null")
        @Min(value = 1900)
        @Max(value = 2025)
        Integer year
) {
}