package com.example.spring_boot_practice.dto;

import lombok.*;


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
