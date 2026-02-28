package com.example.spring_boot_practice.dto;

import com.example.spring_boot_practice.marker.Create;
import com.example.spring_boot_practice.marker.Put;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Year;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarSaveDTO {
    //post
    //put

    @NotNull(groups = Put.class, message = "Id is required when updating a car.")
    @Null(groups = Create.class, message = "Id must be null when creating a new car.")
    private Long id;

    @NotBlank(message = "Brand cannot be blank!")
    @Size(max = 45, message = "Brand must be at most 45 chars")
    private String brand;

    @NotBlank(message = "Model cannot be blank!")
    @Size(max = 45, message = "Model must be at most 45 chars.")
    private String model;

    @NotNull(message = "Year cannot be null!")
    @Min(value = 1900, message = "Year must be 1900 or later.")
    private Integer year;

    @AssertTrue
    public boolean isYearValid() {
        return year == null || year <= Year.now().getValue();
    }
}
