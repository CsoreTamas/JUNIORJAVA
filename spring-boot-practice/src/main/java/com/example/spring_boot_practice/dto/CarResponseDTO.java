package com.example.spring_boot_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDTO {
    //GET
    //GET
    private Long id;
    private String model;
    private String brand;
    private Integer year;
}
