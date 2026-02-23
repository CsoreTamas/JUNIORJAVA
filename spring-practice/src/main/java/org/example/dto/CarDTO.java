package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private long id;

    @NotBlank
    @Size(max = 45)
    private String brand;

    @NotBlank
    @Size(max = 45)
    private String model;

    @NotNull
    @Min(1900)
    @Max(2026)
    private Integer year;
}
