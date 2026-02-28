package com.example.spring_boot_practice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String brand;

    @Column(nullable = false, length = 45)
    private String model;

    //name = "`year`" -> because in the H2 db year is a keyword, and the tests were falling because of it.
    @Column(name = "`year`", nullable = false)
    private int year;
}

