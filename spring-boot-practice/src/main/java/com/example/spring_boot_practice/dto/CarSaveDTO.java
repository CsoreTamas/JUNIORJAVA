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

    @NotBlank(groups = {Create.class, Put.class},message = "Brand cannot be blank!")
    @Size(groups = {Create.class, Put.class},max = 45, message = "Brand must be at most 45 chars")
    private String brand;

    @NotBlank(groups = {Create.class, Put.class},message = "Model cannot be blank!")
    @Size(groups = {Create.class, Put.class},max = 45, message = "Model must be at most 45 chars.")
    private String model;

    @NotNull(message = "Year cannot be null!")
    @Min(value = 1900, groups = {Create.class, Put.class}, message = "Year must be 1900 or later.")
    private Integer year;

    @AssertTrue(groups = {Create.class, Put.class})
    public boolean isYearValid() {
        return year == null || year <= Year.now().getValue();
    }
}
