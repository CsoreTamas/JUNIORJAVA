package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String brand;

    @Column(nullable = false, length = 45)
    private String model;

    @Column(nullable = false, name = "car_year")
    private Integer year;
}