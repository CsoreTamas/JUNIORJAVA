package com.example.spring_boot_practice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarSaveDTO {
    //post
    //put

    @Null(message = "Id must be null when creating a new car")
    private Long id;

    @NotBlank(message = "Brand cannot be blank!")
    @Size(max = 45, message = "Brand must be at most 45 chars")
    private String brand;

    @NotBlank(message = "Model cannot be blank!")
    @Size(max = 45, message = "Model must be at most 45 chars.")
    private String model;

    @NotNull(message = "Year cannot be null!")
    @Min(value = 1900, message = "Year must be 1900 or later.")
    @Max(value = 2026, message = "Year must be realistic")
    private Integer year;
}
